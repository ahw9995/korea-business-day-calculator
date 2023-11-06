package com.example.koreabusinessdaycalculator.api.holiday.service

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.api.holiday.model.openapi.HolidayDataRes
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.CollectionUtils

@Service
class HolidayBatchService(
    private val holidayExternalService: HolidayExternalService,
    private val holidayDataService: HolidayDataService
) {

    @Transactional
    fun updateHolidays() {
        val holidayDataRes = holidayExternalService.getHolidays()

        val holidays = holidayDataRes.response.body.items.item

        val holidayCalendars = holidayDataService.getHolidays()

        // 신규일 경우
        if (CollectionUtils.isEmpty(holidayCalendars)) {
            holidayDataService.saveHolidays(HolidayDataRes.toEntities(holidays))
            return
        }

        // 추가일 업데이트
        val newHolidayCalendar = findNewHoliday(holidays, holidayCalendars!!)

        if (newHolidayCalendar.isNotEmpty()) {
            holidayDataService.saveHolidays(newHolidayCalendar)
        }
    }

    private fun findNewHoliday(
        holidays: List<HolidayDataRes.Holiday>,
        holidayCalendars: List<HolidayCalendar>
    ): List<HolidayCalendar> {

        val newHolidayCalendars: MutableList<HolidayCalendar> = mutableListOf()

        for (holiday in holidays) {

            var newItem = true

            for (holidayCalendar in holidayCalendars) {
                if (holiday.locdate.toString() == holidayCalendar.fullDate) {
                    newItem = false
                    continue
                }
            }

            if (newItem) {
                newHolidayCalendars.add(HolidayDataRes.toEntity(holiday))
            }

        }

        return newHolidayCalendars
    }
}
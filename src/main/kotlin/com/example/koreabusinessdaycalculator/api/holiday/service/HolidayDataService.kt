package com.example.koreabusinessdaycalculator.api.holiday.service

import com.example.koreabusinessdaycalculator.api.holiday.model.HolidayRes
import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.api.holiday.repository.HolidayRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.CollectionUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Service
@Transactional(readOnly = true)
class HolidayDataService(
    private val holidayRepository: HolidayRepository
) {

    fun getHolidays(): HolidayRes {
        return HolidayRes(HolidayRes.fromEntities(this.getHolidaysCurrentYear()))
    }

    fun getHolidaysCurrentYear(): List<HolidayCalendar>? {
        return holidayRepository.findAllByYear(LocalDate.now().year.toString())
    }

    @Transactional
    fun saveHolidays(holidayCalendars: List<HolidayCalendar>) {
        holidayRepository.saveAll(holidayCalendars)
    }

    fun getHolidaysToLocalDate(): List<LocalDate> {

        val holidayCalendars = this.getHolidaysCurrentYear()

        if (CollectionUtils.isEmpty(holidayCalendars)) {
            return Collections.emptyList()
        }

        return holidayCalendars!!.map {
            LocalDate.parse(
                it.fullDate,
                DateTimeFormatter.ofPattern("yyyyMMdd")
            )
        }
    }
}
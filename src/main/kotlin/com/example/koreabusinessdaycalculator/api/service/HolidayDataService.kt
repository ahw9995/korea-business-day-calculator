package com.example.koreabusinessdaycalculator.api.service

import com.example.koreabusinessdaycalculator.api.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.api.model.openapi.HolidayDataRes
import com.example.koreabusinessdaycalculator.api.repository.HolidayRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.CollectionUtils
import java.time.LocalDate

@Service
@Transactional(readOnly = true)
class HolidayDataService(
    private val externalService: ExternalService,
    private val holidayRepository: HolidayRepository
) {

    // TODO: 공휴일 데이터 조회
    fun getHolidays() {

        if (1 == LocalDate.now().dayOfMonth) {
            // TODO:
        }
    }

    fun updateHolidays() {

        val holidayDataRes = externalService.getHolidays()

        val items = holidayDataRes.response.body.items.item

        val holidays = holidayRepository.findAllByYear(LocalDate.now().year.toString())

        // 신규일 경우
        if (CollectionUtils.isEmpty(holidays)) {
            addHoliday(HolidayDataRes.toEntities(items))
            return
        }

        // TODO: 추가해야할 항목만 찾아 insert

    }

    @Transactional
    fun addHoliday(holidayCalendars: List<HolidayCalendar>) {
        holidayRepository.saveAll(holidayCalendars)
    }

    private fun findNewHoliday(
        holidays: List<HolidayDataRes.Holiday>,
        holidayCalendar: List<HolidayCalendar>
    ) {
        // 추가된 것은 저장

        // 없어진 것은 업데이트 enableYn

    }
}
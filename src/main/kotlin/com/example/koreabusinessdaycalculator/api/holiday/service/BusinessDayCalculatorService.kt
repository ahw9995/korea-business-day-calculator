package com.example.koreabusinessdaycalculator.api.holiday.service

import com.example.koreabusinessdaycalculator.api.holiday.model.CalculateType
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.util.StringUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class BusinessDayCalculatorService(private val holidayDataService: HolidayDataService) {

    fun calculatorBusinessDay(type: String, day: Int, date: String?): LocalDate {

        val calculateType = CalculateType.findType(type)

        val calculateDate = if (StringUtils.hasText(date)) LocalDate.parse(
            date,
            DateTimeFormatter.ofPattern("yyyyMMdd")
        ) else LocalDate.now()

        return when (calculateType) {
            CalculateType.BEFORE -> before(day, calculateDate)
            CalculateType.AFTER -> after(day, calculateDate)
        }
    }

    /**
     * 현재일 기준 xx 영업일 이전
     *
     */
    fun beforeFromCurrentDate(day: Int): LocalDate {
        return this.calculator(CalculateType.BEFORE, day, LocalDate.now())
    }

    /**
     * 현재일 기준 xx 영업일 이후
     *
     */
    fun afterFromCurrentDate(day: Int): LocalDate {
        return this.calculator(CalculateType.AFTER, day, LocalDate.now())
    }

    /**
     * 전달 받은 일자 기준 xx 영업일 이전
     *
     */
    fun before(day: Int, date: LocalDate): LocalDate {
        return this.calculator(CalculateType.BEFORE, day, date)
    }

    /**
     * 전달 받은 일자 기준 xx 영업일 이후
     *
     */
    fun after(day: Int, date: LocalDate): LocalDate {
        return this.calculator(CalculateType.AFTER, day, date)
    }

    private fun checkWeekend(date: LocalDate): Boolean {
        val dayValue = date.dayOfWeek.value
        return 6 == dayValue || 7 == dayValue
    }

    private fun calculator(calculateType: CalculateType, day: Int, date: LocalDate): LocalDate {

        val holidayCalendar = holidayDataService.getHolidaysToLocalDate()

        var count = day
        var plusDay = 0
        var checkDate = date


        while (count > 0) {

            checkDate =
                if (CalculateType.AFTER == calculateType) checkDate.plusDays(1)
                else checkDate.minusDays(1)

            if (this.checkWeekend(checkDate) || this.checkHoliday(holidayCalendar, checkDate)) {
                plusDay++
                continue
            }

            count--
        }

        plusDay += day

        return if (CalculateType.AFTER == calculateType) date.plusDays(plusDay.toLong())
        else date.minusDays(plusDay.toLong())
    }

    private fun checkHoliday(holidays: List<LocalDate>, date: LocalDate): Boolean {

        if (CollectionUtils.isEmpty(holidays)) {
            return false
        }

        return holidays.any { it == date }

    }
}
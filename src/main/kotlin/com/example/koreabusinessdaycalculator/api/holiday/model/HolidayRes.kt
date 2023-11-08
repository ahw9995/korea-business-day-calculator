package com.example.koreabusinessdaycalculator.api.holiday.model

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import org.springframework.util.CollectionUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

data class HolidayRes(
    val holidays: List<HolidayData>
) {

    data class HolidayData(
        val holidayDate: LocalDate,
        val dateName: String
    )

    companion object {
        fun fromEntities(holidayCalendars: List<HolidayCalendar>?): List<HolidayData> {

            if (CollectionUtils.isEmpty(holidayCalendars)) {
                return Collections.emptyList()
            }

            return holidayCalendars!!.map {
                HolidayData(
                    LocalDate.parse(
                        it.fullDate,
                        DateTimeFormatter.ofPattern("yyyyMMdd")
                    ), it.dateName
                )
            }
        }
    }
}

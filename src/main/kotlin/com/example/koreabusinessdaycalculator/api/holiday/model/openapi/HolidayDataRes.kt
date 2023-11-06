package com.example.koreabusinessdaycalculator.api.holiday.model.openapi

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.config.annotation.NoArgs
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@NoArgs
data class HolidayDataRes(
    val response: Response
) {
    @NoArgs
    data class Response(
        val header: Header,
        val body: Body
    )

    @NoArgs
    data class Header(
        val resultCode: String,
        val resultMsg: String
    )

    @NoArgs
    data class Body(
        val items: Items,
        val numOfRows: Int,
        val pageNo: Int,
        val totalCount: Int
    )

    @NoArgs
    data class Items(
        val item: List<Holiday>
    )

    @NoArgs
    data class Holiday(
        val dateKind: String,
        val dateName: String,
        val isHoliday: String,
        val locdate: Long,
        val seq: Long
    )

    companion object {

        fun toEntities(holidays: List<Holiday>): List<HolidayCalendar> {
            return holidays.map { toEntity(it) }.toList()
        }

        fun toEntity(holiday: Holiday): HolidayCalendar {

            val date = holiday.locdate.toString()

            val localDate: LocalDate =
                LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"))

            return HolidayCalendar(
                fullDate = date,
                holidayYear = localDate.year.toString(),
                holidayDate = String.format("%02d", localDate.dayOfMonth),
                dateKind = holiday.dateKind,
                dateName = holiday.dateName,
                enableYn = "y"
            )
        }
    }

}

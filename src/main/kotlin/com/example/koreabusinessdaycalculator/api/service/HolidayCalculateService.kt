package com.example.koreabusinessdaycalculator.api.service

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class HolidayCalculateService(private val holidayDataService: HolidayDataService) {

    fun beforeFromCurrentDate(day: Int): LocalDate {
        // TODO: 현재일 기준 xx 영업일 이전
        return LocalDate.now()
    }

    fun afterFromCurrentDate(day: Int): LocalDate {
        // TODO: 현재일 기준 xx 영업일 이후
        return LocalDate.now()
    }

    fun before(day: Int, date: LocalDate): LocalDate {
        // TODO: 전달 받은 일자 기준 xx 영업일 이전
        return LocalDate.now()
    }

    fun after(day: Int, date: LocalDate): LocalDate {
        // TODO: 전달 받은 일자 기준 xx 영업일 이후
        return LocalDate.now()
    }

}
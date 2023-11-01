package com.example.koreabusinessdaycalculator.api.service

import org.junit.jupiter.api.Test
import java.time.LocalDate

class HolidayCalendarDataServiceTest {


    @Test
    fun `1일 찾기`() {
        val now = LocalDate.now()
        assert(now.dayOfMonth == 1)
    }
}
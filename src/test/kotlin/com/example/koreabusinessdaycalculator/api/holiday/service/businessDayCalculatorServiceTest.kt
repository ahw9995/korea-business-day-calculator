package com.example.koreabusinessdaycalculator.api.holiday.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class businessDayCalculatorServiceTest @Autowired constructor(private val businessDayCalculatorService: BusinessDayCalculatorService) {

    @Test
    fun `현재일 기준 3 영업일 이전`() {
        val date = businessDayCalculatorService.beforeFromCurrentDate(3)
        println(date)
    }

    @Test
    fun `현재일 기준 3 영업일 이후`() {
        val date = businessDayCalculatorService.afterFromCurrentDate(3)
        println(date)
    }

    @Test
    fun `전달 받은 일자 기준 3 영업일 이전`() {
        val date = businessDayCalculatorService.before(3, LocalDate.now())
        println(date)
    }

    @Test
    fun `전달 받은 일자 기준 1 영업일 이후`() {
        val date = businessDayCalculatorService.after(1, LocalDate.now())
        println(date)
    }

}
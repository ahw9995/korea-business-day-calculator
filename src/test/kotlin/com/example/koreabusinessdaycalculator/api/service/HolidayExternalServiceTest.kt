package com.example.koreabusinessdaycalculator.api.service

import com.example.koreabusinessdaycalculator.api.holiday.service.HolidayExternalService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.CollectionUtils
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class HolidayExternalServiceTest @Autowired constructor(private val holidayExternalService: HolidayExternalService) {

    @Test
    fun `한국천문연구원 특일정보 조회`() {
        assert(Objects.nonNull(holidayExternalService.getHolidays()))
        assert(!CollectionUtils.isEmpty(holidayExternalService.getHolidays().response.body.items.item))
    }

}
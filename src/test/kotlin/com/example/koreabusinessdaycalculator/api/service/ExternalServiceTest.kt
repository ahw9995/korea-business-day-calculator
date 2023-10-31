package com.example.koreabusinessdaycalculator.api.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.CollectionUtils
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class ExternalServiceTest @Autowired constructor(private val externalService: ExternalService) {

    @Test
    fun `한국천문연구원 특일정보 조회`() {
        assert(Objects.nonNull(externalService.getHolidays()))
        assert(!CollectionUtils.isEmpty(externalService.getHolidays().response.body.items.item))
    }

}
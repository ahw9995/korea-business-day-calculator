package com.example.koreabusinessdaycalculator.api.holiday.controller

import com.example.koreabusinessdaycalculator.api.common.model.ResponseObject
import com.example.koreabusinessdaycalculator.api.holiday.service.HolidayBatchService
import com.example.koreabusinessdaycalculator.api.holiday.service.HolidayCalculateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HolidayController(
    private val holidayBatchService: HolidayBatchService,
    private val holidayCalculateService: HolidayCalculateService
) {

    @PostMapping("/batch/update-holidays")
    fun updateHolidays(): ResponseEntity<ResponseObject<Any>> {

        holidayBatchService.updateHolidays()
        return ResponseEntity.ok().body(ResponseObject())
    }

}
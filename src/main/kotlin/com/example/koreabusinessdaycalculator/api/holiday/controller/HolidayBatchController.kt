package com.example.koreabusinessdaycalculator.api.holiday.controller

import com.example.koreabusinessdaycalculator.api.common.model.ResponseObject
import com.example.koreabusinessdaycalculator.api.holiday.service.HolidayBatchService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "배치 API", description = "배치 API")
@RestController
class HolidayBatchController(
    private val holidayBatchService: HolidayBatchService
) {

    @Operation(summary = "한국천문연구원 휴일 정보 API를 통해 휴일정보 가져와 업데이트 하는 배치")
    @PostMapping("/batch/update-holidays")
    fun updateHolidays(): ResponseEntity<ResponseObject<Any>> {

        holidayBatchService.updateHolidays()
        return ResponseEntity.ok().body(ResponseObject())
    }
}
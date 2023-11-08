package com.example.koreabusinessdaycalculator.api.holiday.controller

import com.example.koreabusinessdaycalculator.api.common.model.ResponseObject
import com.example.koreabusinessdaycalculator.api.holiday.model.HolidayRes
import com.example.koreabusinessdaycalculator.api.holiday.service.BusinessDayCalculatorService
import com.example.koreabusinessdaycalculator.api.holiday.service.HolidayDataService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "영업일 계산기 API", description = "영업일 계산, 휴일 정보 조회 API 제공")
@RestController
class HolidayCalculatorController(
    private val businessDayCalculatorService: BusinessDayCalculatorService,
    private val holidayDataService: HolidayDataService
) {

    @Operation(summary = "현재년도 기준 공휴일 정보를 모두 조회 하는 API")
    @GetMapping("/korea-holidays")
    fun getKoreaHolidays(): ResponseEntity<ResponseObject<HolidayRes>> {
        return ResponseEntity.ok().body(ResponseObject(holidayDataService.getHolidays()))
    }

    @Operation(summary = "영업일 계산 API")
    @GetMapping("/calculator/business-day")
    fun calculatorBusinessDay(
        @RequestParam("type", required = true) @Parameter(description = "before: 이전 일 계산, after: 이후 일 계산") type: String,
        @RequestParam("day", required = true) @Parameter(description = "계산하고자 하는 일 수") day: Int,
        @RequestParam("date", required = false) @Parameter(description = "날짜포맷: yyyyMMdd", required = false) date: String?
    ): ResponseEntity<ResponseObject<Any>> {
        return ResponseEntity.ok().body(
            ResponseObject(businessDayCalculatorService.calculatorBusinessDay(type, day, date))
        )
    }
}
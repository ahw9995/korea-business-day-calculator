package com.example.koreabusinessdaycalculator.api.holiday.repository

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar

interface HolidayRepositoryCustom {

    fun findAllByYear(year: String): List<HolidayCalendar>?
}
package com.example.koreabusinessdaycalculator.api.repository

import com.example.koreabusinessdaycalculator.api.model.entity.HolidayCalendar

interface HolidayRepositoryCustom {

    fun findAllByYear(year: String): List<HolidayCalendar>?
}
package com.example.koreabusinessdaycalculator.api.holiday.repository

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import org.springframework.data.jpa.repository.JpaRepository

interface HolidayRepository: JpaRepository<HolidayCalendar, String>, HolidayRepositoryCustom {
}
package com.example.koreabusinessdaycalculator.api.repository

import com.example.koreabusinessdaycalculator.api.model.entity.HolidayCalendar
import org.springframework.data.jpa.repository.JpaRepository

interface HolidayRepository: JpaRepository<HolidayCalendar, String>, HolidayRepositoryCustom {
}
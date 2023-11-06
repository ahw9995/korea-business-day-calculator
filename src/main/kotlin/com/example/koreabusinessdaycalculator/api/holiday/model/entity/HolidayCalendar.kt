package com.example.koreabusinessdaycalculator.api.holiday.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "holiday_calendar")
data class HolidayCalendar(
 @Id
 @Column(name = "full_date", nullable = false)
 val fullDate: String,
 @Column(name = "holiday_year", nullable = false)
 val holidayYear: String,
 @Column(name = "holiday_date", nullable = false)
 val holidayDate: String,
 @Column(name = "date_kind", nullable = false)
 val dateKind: String,
 @Column(name = "date_name", nullable = false)
 val dateName: String,
 @Column(name = "enable_yn", nullable = false)
 val enableYn: String,
 @Column(name = "created_at", nullable = true)
 val createdAt: LocalDateTime
)

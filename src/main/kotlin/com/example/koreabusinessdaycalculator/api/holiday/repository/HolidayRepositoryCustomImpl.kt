package com.example.koreabusinessdaycalculator.api.holiday.repository

import com.example.koreabusinessdaycalculator.api.holiday.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.api.holiday.model.entity.QHolidayCalendar.holidayCalendar
import com.querydsl.jpa.impl.JPAQueryFactory


class HolidayRepositoryCustomImpl(private val queryFactory: JPAQueryFactory) :
    HolidayRepositoryCustom {
    override fun findAllByYear(year: String): List<HolidayCalendar>? {
        return queryFactory.select(holidayCalendar).from(holidayCalendar)
            .where(holidayCalendar.holidayYear.eq(year))
            .fetch()
    }
}
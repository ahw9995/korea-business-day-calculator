package com.example.koreabusinessdaycalculator.api.repository

import com.example.koreabusinessdaycalculator.api.model.entity.HolidayCalendar
import com.example.koreabusinessdaycalculator.api.model.entity.QHoliday.holiday
import com.querydsl.jpa.impl.JPAQueryFactory


class HolidayRepositoryCustomImpl(private val queryFactory: JPAQueryFactory) :
    HolidayRepositoryCustom {
    override fun findAllByYear(year: String): List<HolidayCalendar>? {
        return queryFactory.select(holiday).from(holiday).where(holiday.holidayYear.eq(year))
            .fetch()
    }
}
package com.example.koreabusinessdaycalculator.api.holiday.model.entity

import com.example.koreabusinessdaycalculator.api.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.domain.Persistable

@Entity
@Table(name = "holiday_calendar")
class HolidayCalendar(
    @Id
    @Column(name = "full_date", nullable = false, length = 8)
    var fullDate: String? = "",

    @Column(name = "holiday_year", nullable = false, length = 4)
    var holidayYear: String = "",

    @Column(name = "holiday_date", nullable = false, length = 4)
    var holidayDate: String = "",

    @Column(name = "date_kind", nullable = false, length = 2)
    var dateKind: String = "",

    @Column(name = "date_name", nullable = false, length = 50)
    var dateName: String = "",

    @Column(name = "enable_yn", nullable = false, length = 1)
    var enableYn: String = ""
) : BaseEntity(), Persistable<String> {

    override fun getId(): String? {
        return fullDate
    }

    override fun isNew(): Boolean {
        return super.createdAt == null
    }
}

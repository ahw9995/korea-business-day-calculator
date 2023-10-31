package com.example.koreabusinessdaycalculator.api.model.external

import com.example.koreabusinessdaycalculator.config.annotation.NoArgs

@NoArgs
data class Holiday(
    val dateKind: String,
    val dateName: String,
    val isHoliday: String,
    val locdate: Long,
    val seq: Long
)

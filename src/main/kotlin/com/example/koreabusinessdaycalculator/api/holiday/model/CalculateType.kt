package com.example.koreabusinessdaycalculator.api.holiday.model

enum class CalculateType(val code: String) {
    BEFORE("before"),
    AFTER("after")
    ;

    companion object {
        fun findType(code: String): CalculateType {
            return values().find { it.code == code }!!
        }
    }
}
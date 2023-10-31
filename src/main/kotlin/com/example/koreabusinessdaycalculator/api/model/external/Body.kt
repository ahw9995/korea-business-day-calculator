package com.example.koreabusinessdaycalculator.api.model.external

import com.example.koreabusinessdaycalculator.config.annotation.NoArgs

@NoArgs
data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)



package com.example.koreabusinessdaycalculator.api.model.external

import com.example.koreabusinessdaycalculator.config.annotation.NoArgs

@NoArgs
data class Items(
    val item: List<Holiday>
)

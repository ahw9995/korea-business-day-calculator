package com.example.koreabusinessdaycalculator.api.model.external

import com.example.koreabusinessdaycalculator.config.annotation.NoArgs

@NoArgs
data class Header(
    val resultCode: String,
    val resultMsg: String
)

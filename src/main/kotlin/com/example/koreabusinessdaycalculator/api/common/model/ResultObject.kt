package com.example.koreabusinessdaycalculator.api.common.model

import com.example.koreabusinessdaycalculator.api.common.exception.ErrorMessageType


data class ResultObject(var code: String, var message: String) {
    constructor(type: ErrorMessageType) : this(
        type.code,
        type.message
    )
}
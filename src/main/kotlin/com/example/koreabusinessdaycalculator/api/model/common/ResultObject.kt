package com.example.koreabusinessdaycalculator.api.model.common

import com.example.koreabusinessdaycalculator.api.exception.ErrorMessageType


data class ResultObject(var code: String, var message: String) {
    constructor(type: ErrorMessageType) : this(
        type.code,
        type.message
    )
}
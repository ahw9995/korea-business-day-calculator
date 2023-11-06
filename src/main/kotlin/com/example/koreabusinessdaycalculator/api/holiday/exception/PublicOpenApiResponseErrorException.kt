package com.example.koreabusinessdaycalculator.api.holiday.exception

data class PublicOpenApiResponseErrorException(
    override val message: String,
    val errorCode: String
) :
    RuntimeException(message)
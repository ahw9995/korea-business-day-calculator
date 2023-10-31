package com.example.koreabusinessdaycalculator.api.exception

data class PublicOpenApiResponseErrorException(
    override val message: String,
    val errorCode: String
) :
    RuntimeException(message)
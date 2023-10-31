package com.example.koreabusinessdaycalculator.api.exception

data class PublicOpenApiResponseNotFoundException(
    override val message: String,
    val errorCode: String
) :
    RuntimeException(message) {
    constructor() : this(
        ErrorMessageType.PUBLIC_OPEN_API_RESPONSE_NOT_FOUND_EXCEPTION.message,
        ErrorMessageType.PUBLIC_OPEN_API_RESPONSE_NOT_FOUND_EXCEPTION.code
    )
}
package com.example.koreabusinessdaycalculator.api.common.exception

import com.example.koreabusinessdaycalculator.api.common.model.ResponseObject
import com.example.koreabusinessdaycalculator.api.common.model.ResultObject
import com.example.koreabusinessdaycalculator.api.holiday.exception.PublicOpenApiResponseErrorException
import com.example.koreabusinessdaycalculator.api.holiday.exception.PublicOpenApiResponseNotFoundException
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    private val log = KotlinLogging.logger {}

    @ExceptionHandler(PublicOpenApiResponseNotFoundException::class)
    fun publicOpenApiResponseNotFoundExceptionHandler(e: PublicOpenApiResponseNotFoundException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(e.errorCode, e.message)))
    }

    @ExceptionHandler(PublicOpenApiResponseErrorException::class)
    fun publicOpenApiResponseErrorExceptionHandler(e: PublicOpenApiResponseErrorException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(e.errorCode, e.message)))
    }

}
package com.example.koreabusinessdaycalculator.api.exception

import com.example.koreabusinessdaycalculator.api.model.common.ResponseObject
import com.example.koreabusinessdaycalculator.api.model.common.ResultObject
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
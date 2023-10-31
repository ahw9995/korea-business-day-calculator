package com.example.koreabusinessdaycalculator.api.service

import com.example.koreabusinessdaycalculator.api.exception.PublicOpenApiResponseErrorException
import com.example.koreabusinessdaycalculator.api.exception.PublicOpenApiResponseNotFoundException
import com.example.koreabusinessdaycalculator.api.model.external.HolidayDataRes
import com.example.koreabusinessdaycalculator.properties.OpenApiProperties
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.LocalDate

@Service
class ExternalService(private val openApiProperties: OpenApiProperties) {

    fun getHolidays(): HolidayDataRes {

        val webClient = WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val res = webClient.get().uri(getUri()).retrieve().bodyToMono(HolidayDataRes::class.java)
            .timeout(Duration.ofSeconds(10))

        if (res.block() == null) {
            throw PublicOpenApiResponseNotFoundException()
        }

        val holidayDataRes = res.block()

        if ("00" != holidayDataRes!!.response.header.resultCode) {
            val error = holidayDataRes.response.header
            throw PublicOpenApiResponseErrorException(error.resultMsg, error.resultCode)
        }

        return holidayDataRes
    }

    private fun getUri(): URI {
        return UriComponentsBuilder.fromHttpUrl(openApiProperties.holidayUrl)
            .encode(StandardCharsets.UTF_8)
            .queryParam("serviceKey", openApiProperties.authKey)
            .queryParam("solYear", LocalDate.now().year.toString())
            .queryParam("_type", "json")
            .queryParam("numOfRows", "1000").build(true).toUri()
    }
}
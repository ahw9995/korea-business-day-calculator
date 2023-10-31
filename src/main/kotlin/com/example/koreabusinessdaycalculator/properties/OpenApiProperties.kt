package com.example.koreabusinessdaycalculator.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("data-go-kr")
data class OpenApiProperties(
    val authKey: String,
    val holidayUrl: String
)

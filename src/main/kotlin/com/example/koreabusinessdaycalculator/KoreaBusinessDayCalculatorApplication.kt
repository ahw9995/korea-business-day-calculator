package com.example.koreabusinessdaycalculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@ConfigurationPropertiesScan
class KoreaBusinessDayCalculatorApplication

fun main(args: Array<String>) {
    runApplication<KoreaBusinessDayCalculatorApplication>(*args)
}

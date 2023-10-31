package com.example.koreabusinessdaycalculator.properties

import org.junit.jupiter.api.Test
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource
import org.springframework.util.StringUtils

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@EnableConfigurationProperties(OpenApiProperties::class)
@TestPropertySource("classpath:application.yml")
class OpenApiPropertiesTest(private val openApiProperties: OpenApiProperties) {

    @Test
    fun `공공데이터 인증키 properties 조회`() {
        println(openApiProperties.authKey)
        assert(StringUtils.hasText(openApiProperties.authKey))
    }

}
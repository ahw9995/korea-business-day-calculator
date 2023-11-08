package com.example.koreabusinessdaycalculator.config.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiDocConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI().components(Components()).info(this.setInfo())
    }

    private fun setInfo(): Info {
        val info = Info()

        info.title = "한국 영업일 계산기 API Doc"
        info.description = "한국 영업일 계산기와 관련된 API가 포함됨"
        info.version = "1.0.0"

        return info
    }
}
package com.studio.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(
    info = Info(
        title = "Bump API",
        version = "1.0.0",
        description = "위치기반 Bump Project"
    ),
    servers = [Server(url = "/")]
)
@Configuration
class OpenApiConfig {

    @Bean
    fun api(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("bump")
        .packagesToScan("com.studio")
        .build()

    @Bean
    fun customOpenAPI(): OpenAPI? {
        return OpenAPI()
            .addSecurityItem(SecurityRequirement().addList("JWT", mutableListOf()))
            .components(
                Components()
                    .addSecuritySchemes(
                        "JWT", SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            )
    }
}
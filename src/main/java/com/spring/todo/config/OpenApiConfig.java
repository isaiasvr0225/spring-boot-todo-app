package com.spring.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @package : com.spring.todo.config
 * @name : OpenApiConfig.java
 * @date : 2024-04-12
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
public @Configuration class OpenApiConfig {

    private static final String API_NAME = "Task Management API";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "This API is used to manage tasks.";

    @Bean
    public OpenAPI OpenAPIConfig() {
        return new OpenAPI()
                .info(new Info().title(API_NAME).description(API_DESCRIPTION).version(API_VERSION));
    }
}

package com.restaurant.restaurant_app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OpenAPI swaggerUISetup(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Backend Application - Training")
                                .description("Sample project for backend training")
                );
    }
}

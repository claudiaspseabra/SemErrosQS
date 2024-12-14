package com.example.qsproject.qsproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * Configures Cross-Origin Resource Sharing (CORS) to allow requests from "http://localhost:5173" for local development.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures the CORS mapping to allow requests from the specified origin.
     *
     * @param registry The CorsRegistry object that holds the CORS mappings.
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:5173");
    }
}
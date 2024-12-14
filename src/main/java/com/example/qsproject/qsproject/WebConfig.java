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
     * Configura as permissões de CORS para permitir requisições da origem especificada.
     *
     * @param registry O objeto CorsRegistry que contém as configurações de CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Content-Type", "Authorization", "X-Custom-Header");
    }
}
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir acceso desde los otros microservicios (8081, 8082, 8083)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081", "http://localhost:8082", "http://localhost:8083")  // Asegúrate de añadir los puertos de los microservicios
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

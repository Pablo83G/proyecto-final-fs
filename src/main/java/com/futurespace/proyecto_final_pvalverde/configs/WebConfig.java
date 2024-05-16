package com.futurespace.proyecto_final_pvalverde.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class WebConfig {

        /*public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**") // Permitir todas las rutas
                            .allowedOrigins("http://localhost:3000", "http://192.168.4.83:3000");// Ruta de despliegue del front

                }
            };*/
            @Bean
            public WebMvcConfigurer corsConfigurer() {
                return new WebMvcConfigurer() {
                    @Override
                    public void addCorsMappings(CorsRegistry registry) {
                        registry.addMapping("/**") // Permitir todas las rutas
                                .allowedOrigins("http://localhost:3000", "http://192.168.4.83:3000") // Ruta de despliegue del front
                                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                                .allowedHeaders("*")
                                .allowCredentials(true);
                    }
                };
            }
        }



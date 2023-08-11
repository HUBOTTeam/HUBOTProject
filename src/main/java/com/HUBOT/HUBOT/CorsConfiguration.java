package com.HUBOT.HUBOT;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/createUser") // Specify the endpoint you want to allow CORS for
                        .allowedOrigins("http://localhost:3000") // Allow requests from this origin
                        .allowedMethods("POST") // Allow POST requests
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}

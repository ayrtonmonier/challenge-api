package com.ayrtonmonier.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String csvUrl() {
        return "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv";
    }

    
    @Bean
    public String jsonUrl() {
        return " https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json";
    }
    
   
    // Outras configurações e beans...
}

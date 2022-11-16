package com.example.elisity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.http.HttpClient;

@Configuration
@EnableScheduling
@SpringBootApplication
public class ElisityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElisityApplication.class, args);
    }
}

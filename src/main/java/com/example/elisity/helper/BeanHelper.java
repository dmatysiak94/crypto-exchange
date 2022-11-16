package com.example.elisity.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class BeanHelper {
    @Bean(name = "ObjectMapperGen")
    public ObjectMapper objectMapperGen(){
        return new ObjectMapper();
    }

    @Bean(name = "HttpClientGen")
    public HttpClient createHttpClient() {
        return HttpClient.newHttpClient();
    }
}

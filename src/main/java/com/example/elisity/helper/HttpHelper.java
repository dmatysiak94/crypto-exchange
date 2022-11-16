package com.example.elisity.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpHelper {

    HttpClient httpClient;
    ObjectMapper objectMapper;

    public HttpHelper(BeanHelper beanHelper) {
        this.httpClient = beanHelper.createHttpClient();
        this.objectMapper = beanHelper.objectMapperGen();
    }

    public JSONObject getGenericObjectFromService(String endpoint, String[] header) throws URISyntaxException, IOException,
            InterruptedException {

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(endpoint))
                .headers(header)
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        return new JSONObject(new JSONTokener(response.body()));
    }
}

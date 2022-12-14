package com.example.appapi.util;

import com.example.appapi.model.dto.MessageKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class KafkaServiceUtil {
    private final RestTemplate restTemplate;
    public void sendMessage(MessageKafka messageKafka, String url){
        restTemplate.exchange(url, HttpMethod.POST, createHeaderAndBody(messageKafka), String.class);
    }
    public HttpEntity<?> createHeaderAndBody(MessageKafka messageKafka){
        return new HttpEntity<>(messageKafka, headerCommon());
    }

    public HttpHeaders headerCommon(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Accept", "application/json");
        httpHeaders.add("Connection", "keep-alive");
        return httpHeaders;
    }
}

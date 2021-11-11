package com.flock.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HttpClient {

    @Value("${provinces.public.api.url}")
    private String provincesPublicApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getProvincesData(){

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(provincesPublicApiUrl);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        return response.getBody();

    }

}

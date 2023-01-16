package com.example.democlient.tool;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {
    private String server = "http://localhost:8082/";
    private RestTemplate template;
    private HttpHeaders headers;
    private HttpStatusCode status;

    public RestClient() {
        template = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("content-type", "application/json");
    }
    public String get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = template.exchange(server + uri, HttpMethod.GET, requestEntity,String.class);
        status = responseEntity.getStatusCode();
        return responseEntity.getBody();
    }
}

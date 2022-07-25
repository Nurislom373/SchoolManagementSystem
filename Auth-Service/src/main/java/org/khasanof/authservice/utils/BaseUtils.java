package org.khasanof.authservice.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
public class BaseUtils {
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;
    public static final RestTemplate REST_TEMPLATE = new RestTemplate();
    public static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static ResponseEntity<String> sendUrl(String url, HttpMethod httpMethod, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return REST_TEMPLATE.exchange(url, httpMethod, entity, new ParameterizedTypeReference<>() {
        });
    }

    public static ResponseEntity<String> sendUrl(String url, HttpMethod httpMethod, MediaType mediaType, String bearer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer ".concat(bearer));
        headers.setContentType(mediaType);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return REST_TEMPLATE.exchange(url, httpMethod, entity, new ParameterizedTypeReference<>() {
        });
    }

    public static ResponseEntity<String> sendUrl(String url, HttpMethod httpMethod, MediaType mediaType, JSONObject jsonObject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        return REST_TEMPLATE.exchange(url, httpMethod, entity, new ParameterizedTypeReference<>() {
        });
    }

    public static ResponseEntity<String> sendUrl(String url, HttpMethod httpMethod, MediaType mediaType, JSONObject jsonObject, String bearer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer ".concat(bearer));
        headers.setContentType(mediaType);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        return REST_TEMPLATE.exchange(url, httpMethod, entity, new ParameterizedTypeReference<>() {
        });
    }
}

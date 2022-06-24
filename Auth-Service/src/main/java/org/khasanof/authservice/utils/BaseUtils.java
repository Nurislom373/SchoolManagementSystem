package org.khasanof.authservice.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
public class BaseUtils {
    public static final RestTemplate REST_TEMPLATE = new RestTemplate();
}

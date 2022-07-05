package org.khasanof.authservice.utils;

import lombok.Getter;
import lombok.Setter;
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
}

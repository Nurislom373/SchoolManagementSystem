package org.khasanof.gatewayservice.config.routerValidator;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {
    public static final List<String> WHITE_LIST = List.of(
            "/api/v1/auth/login",
            "/api/v1/auth/register");

    public Predicate<ServerHttpRequest> isSecured =
            serverHttpRequest ->
                            WHITE_LIST.stream()
                                    .noneMatch(uri -> serverHttpRequest.getURI()
                                            .getPath()
                                            .contains(uri));
}

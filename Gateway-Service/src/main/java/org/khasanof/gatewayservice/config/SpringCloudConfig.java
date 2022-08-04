package org.khasanof.gatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.khasanof.gatewayservice.config.filter.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringCloudConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route("Classroom-Service", r -> r.path("/api/v1/classroom/**", "/api/v1/classroomStudent/**", "/api/v1/course/**", "/api/v1/grade/**")
                        .uri("lb://Classroom-Service"))
                .route("Auth-Service", r -> r.path("/api/v1/auth/**")
                        .uri("lb://Auth-Service"))
                .build();
    }
//    http://localhost:8800/
}

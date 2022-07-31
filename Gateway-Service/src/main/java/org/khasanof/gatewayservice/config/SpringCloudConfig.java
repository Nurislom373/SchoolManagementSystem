package org.khasanof.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route("Classroom-Service", r -> r.path("/classroom/**", "/classroomStudent/**")
                        .uri("http://localhost:8005/"))
                .route("Auth-Service", r -> r.path("/auth/**")
                        .uri("http://localhost:8800/"))
                .build();
    }
}

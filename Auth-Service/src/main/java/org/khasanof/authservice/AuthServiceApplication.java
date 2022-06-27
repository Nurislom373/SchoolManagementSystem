package org.khasanof.authservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.khasanof.authservice.properties.OpenApiProperties;
import org.khasanof.authservice.properties.ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@OpenAPIDefinition
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({OpenApiProperties.class, ServiceProperties.class})
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}

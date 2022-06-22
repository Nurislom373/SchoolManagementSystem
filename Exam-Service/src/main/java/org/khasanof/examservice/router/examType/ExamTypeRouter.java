package org.khasanof.examservice.router.examType;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.examType.ExamTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ExamTypeRouter {

    private final ExamTypeService service;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/exam_type/{id}", service::get)
                .GET("/exam_type", service::getAll)
                .POST("/exam_type", service::save)
                .build();
    }
}

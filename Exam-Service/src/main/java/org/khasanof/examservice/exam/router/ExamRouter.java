package org.khasanof.examservice.exam.router;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.exam.handler.ExamHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ExamRouter {
    private final ExamHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/exam", handler::getAll)
                .GET("/exam/{id}", handler::get)
                .POST("/exam/create", handler::save)
                .PUT("/exam/update/{id}", handler::update)
                .DELETE("/exam/delete/{id}", handler::delete)
                .build();
    }
}

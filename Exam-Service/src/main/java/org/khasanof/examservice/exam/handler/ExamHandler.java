package org.khasanof.examservice.exam.handler;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.exam.ExamService;
import org.khasanof.examservice.exam.dto.ExamCreateDTO;
import org.khasanof.examservice.exam.dto.ExamGetDTO;
import org.khasanof.examservice.exam.dto.ExamUpdateDTO;
import org.khasanof.examservice.exam.entity.Exam;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExamHandler {

    private final ExamService service;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(service.getAll(), ExamGetDTO.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().body(service.get(request.pathVariable("id")), ExamGetDTO.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return ServerResponse.ok().body(service.delete(request.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return ServerResponse.ok().body(service.save(request.bodyToMono(ExamCreateDTO.class)), ExamGetDTO.class);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return ServerResponse.ok().body(service.update(request.bodyToMono(ExamUpdateDTO.class), request.pathVariable("id")), ExamGetDTO.class);
    }


}

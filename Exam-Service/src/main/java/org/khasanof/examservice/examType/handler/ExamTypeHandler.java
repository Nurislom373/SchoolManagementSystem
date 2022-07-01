package org.khasanof.examservice.examType.handler;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.examType.ExamTypeService;
import org.khasanof.examservice.examType.dto.ExamTypeCreateDTO;
import org.khasanof.examservice.examType.dto.ExamTypeGetDTO;
import org.khasanof.examservice.examType.dto.ExamTypeUpdateDTO;
import org.khasanof.examservice.examType.entity.ExamType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExamTypeHandler {
    private final ExamTypeService service;

    public Mono<ServerResponse> save(ServerRequest request) {
        return ServerResponse.ok().body(service.save(request.bodyToMono(ExamTypeCreateDTO.class)), ExamType.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return ServerResponse.ok().body(service.delete(request.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return ServerResponse.ok().body(service.update(request.bodyToMono(ExamTypeUpdateDTO.class), request.pathVariable("id")), ExamType.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().body(service.get(request.pathVariable("id")), ExamTypeGetDTO.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(service.getAll(), ExamTypeGetDTO.class);
    }

}

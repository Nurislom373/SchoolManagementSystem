package org.khasanof.examservice.examResult.handler;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.examResult.ExamResultService;
import org.khasanof.examservice.examResult.dto.ExamResultCreateDTO;
import org.khasanof.examservice.examResult.dto.ExamResultGetDTO;
import org.khasanof.examservice.examResult.dto.ExamResultUpdateDTO;
import org.khasanof.examservice.examResult.entity.ExamResult;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record ExamResultHandler(ExamResultService service) {

    public Mono<ServerResponse> save(ServerRequest request) {
        return ServerResponse.ok().body(service.save(request.bodyToMono(ExamResultCreateDTO.class)), ExamResult.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return ServerResponse.ok().body(service.delete(request.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().body(service.get(request.pathVariable("id")), ExamResultGetDTO.class);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return ServerResponse.ok().body(service.update(request.bodyToMono(ExamResultUpdateDTO.class), request.pathVariable("id")), ExamResultGetDTO.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(service.getAll(), ExamResultGetDTO.class);
    }

}

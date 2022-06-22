package org.khasanof.examservice.examType;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExamTypeService {

    private final ExamTypeRepository repository;
    private final ExamTypeMapper mapper;

    Logger logger = LoggerFactory.getLogger(ExamTypeService.class);

    public Mono<ServerResponse> save(ServerRequest request) {
        logger.info("save thread name -> " + Thread.currentThread().getName());
        return ServerResponse.ok().body(request.bodyToMono(ExamTypeCreateDTO.class).map(mapper::toCreateDTO).flatMap(repository::save), ExamType.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String id = request.pathVariable("id");
        logger.info("get thread name -> " + Thread.currentThread().getName());
        return ServerResponse.ok().body(repository.findById(id), ExamType.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        logger.info("get all thread name -> " + Thread.currentThread().getName());
        return ServerResponse.ok().body(repository.findAll(), ExamType.class);
    }
}

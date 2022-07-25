package org.khasanof.examservice.examType;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.exam.ExamService;
import org.khasanof.examservice.examResult.ExamResultService;
import org.khasanof.examservice.examType.dto.ExamTypeCreateDTO;
import org.khasanof.examservice.examType.dto.ExamTypeGetDTO;
import org.khasanof.examservice.examType.dto.ExamTypeUpdateDTO;
import org.khasanof.examservice.examType.entity.ExamType;
import org.khasanof.examservice.exception.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExamTypeService {

    private final ExamTypeRepository repository;
    private final ExamService examService;
    private final ExamResultService examResultService;
    private final ExamTypeMapper mapper;

    Logger logger = LoggerFactory.getLogger(ExamTypeService.class);

    public Mono<ExamType> save(Mono<ExamTypeCreateDTO> mono) {
        logger.info("save thread name -> " + Thread.currentThread().getName());
        return mono.map(mapper::toCreateDTO).flatMap(repository::save);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Mono<ExamTypeGetDTO> get(String id) {
        return repository.findById(id).map(mapper::fromGetDTO);
    }

    public Flux<ExamTypeGetDTO> getAll() {
        return repository.findAll().map(mapper::fromGetDTO);
    }

    public Mono<ExamType> update(Mono<ExamTypeUpdateDTO> mono, String id) {
        return repository.findById(id).flatMap(e -> mono.map(mapper::toUpdateDTO).doOnNext(p -> p.setId(id))).flatMap(repository::save);
    }
}

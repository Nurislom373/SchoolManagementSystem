package org.khasanof.examservice.exam;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.exam.dto.ExamCreateDTO;
import org.khasanof.examservice.exam.dto.ExamGetDTO;
import org.khasanof.examservice.exam.dto.ExamUpdateDTO;
import org.khasanof.examservice.exam.entity.Exam;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamMapper mapper;
    private final ExamRepository repository;

    public Mono<Exam> save(Mono<ExamCreateDTO> mono) {
        return mono.map(mapper::toCreateDTO).flatMap(repository::save);
    }

    public Mono<Exam> update(Mono<ExamUpdateDTO> mono, String id) {
        return repository.findById(id).flatMap(e -> mono.map(mapper::toUpdateDTO).doOnNext(p -> p.setId(id))).flatMap(repository::save);
    }

    public Flux<ExamGetDTO> getAll() {
        return repository.findAll().map(mapper::fromGetDTO);
    }

    public Mono<ExamGetDTO> get(String id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Id is null");
        }
        return repository.findById(id).map(mapper::fromGetDTO);
    }

    public Mono<Void> delete(String id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Id is null");
        }
        return repository.deleteById(id);
    }

}

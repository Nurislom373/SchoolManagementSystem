package org.khasanof.examservice.examResult;

import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.examResult.dto.ExamResultCreateDTO;
import org.khasanof.examservice.examResult.dto.ExamResultGetDTO;
import org.khasanof.examservice.examResult.dto.ExamResultUpdateDTO;
import org.khasanof.examservice.examResult.entity.ExamResult;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExamResultService {
    private final ExamResultRepository repository;
    private final ExamResultMapper mapper;

    public Flux<ExamResultGetDTO> getAll() {
        return repository.findAll().map(mapper::fromGetDTO);
    }

    public Mono<ExamResult> save(Mono<ExamResultCreateDTO> mono) {
        return mono.map(mapper::toCreateDTO).flatMap(repository::save);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Mono<ExamResultGetDTO> get(String id) {
        return repository.findById(id).map(mapper::fromGetDTO);
    }

    public Mono<ExamResult> update(Mono<ExamResultUpdateDTO> mono, String id) {
        return repository.findById(id).flatMap(e -> mono.map(mapper::toUpdateDTO).doOnNext(p -> p.setId(id))).flatMap(repository::save);
    }
}

package org.khasanof.examservice.examResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.khasanof.examservice.exam.ExamService;
import org.khasanof.examservice.examResult.dto.*;
import org.khasanof.examservice.examResult.entity.ExamResult;
import org.khasanof.examservice.response.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

@Service
@RequiredArgsConstructor
public class ExamResultService {
    private final ExamResultRepository repository;
    private final ExamResultMapper mapper;
    private final WebClient webClient = WebClient.create("http://localhost:8800");
    private final ExamService examService;
    private final ObjectMapper objectMapper;

    public Flux<ExamResultGetDTO> getAll() {
        return repository.findAll().map(mapper::fromGetDTO);
    }

    public Mono<ExamResult> save(Mono<ExamResultCreateDTO> mono) {
        return mono.map(mapper::toCreateDTO).flatMap(repository::save);
    }

    public Mono<ExamResultDetailDTO> detail(String id) {
        return repository.findById(id)
                .flatMap(examResult -> Mono.just(examResult)
                        .map(mapper::fromDetailDTO)
                        .zipWith(webClient.get()
                                .uri("/student/get/{id}", examResult.getStudentId())
                                .retrieve()
                                .bodyToMono(Data.class)
                        )
                        .publishOn(Schedulers.boundedElastic())
                        .doOnNext(e -> e.getT1().setExam(examService.get(examResult.getExamId()).block()))
                ).doOnNext(objects -> objects.getT1().setStudent(objectMapper.convertValue(objects.getT2().getData(), StudentGetDTO.class)))
                .map(Tuple2::getT1);
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

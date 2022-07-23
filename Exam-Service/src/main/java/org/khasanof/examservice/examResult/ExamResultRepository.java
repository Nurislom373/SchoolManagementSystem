package org.khasanof.examservice.examResult;

import org.khasanof.examservice.examResult.entity.ExamResult;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface ExamResultRepository extends ReactiveMongoRepository<ExamResult, String> {
    @Transactional
    Mono<Void> deleteById(String id);

    Flux<ExamResult> findAllByStudentIdEquals(String id);

    Mono<Void> deleteAllByStudentIdEquals(String id);

}

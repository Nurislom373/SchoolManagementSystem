package org.khasanof.examservice.examResult;

import org.khasanof.examservice.examResult.entity.ExamResult;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public interface ExamResultRepository extends ReactiveMongoRepository<ExamResult, String> {

    @Transactional
    Mono<Void> deleteById(String id);
}

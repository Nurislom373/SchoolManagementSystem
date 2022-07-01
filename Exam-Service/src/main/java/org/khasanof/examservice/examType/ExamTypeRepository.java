package org.khasanof.examservice.examType;

import org.khasanof.examservice.examType.entity.ExamType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public interface ExamTypeRepository extends ReactiveMongoRepository<ExamType, String> {

    @Transactional
    Mono<Void> deleteById(String id);
}

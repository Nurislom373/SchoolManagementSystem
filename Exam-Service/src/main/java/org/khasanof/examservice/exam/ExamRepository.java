package org.khasanof.examservice.exam;

import org.khasanof.examservice.exam.entity.Exam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ExamRepository extends ReactiveMongoRepository<Exam, String>, ReactiveSortingRepository<Exam, String> {
    Flux<Exam> findAllBy(Pageable pageable);
}

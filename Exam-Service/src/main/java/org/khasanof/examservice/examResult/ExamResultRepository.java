package org.khasanof.examservice.examResult;

import org.khasanof.examservice.examResult.entity.ExamResult;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository extends ReactiveMongoRepository<ExamResult, String> {
}

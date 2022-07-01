package org.khasanof.examservice.examType;

import org.khasanof.examservice.examType.entity.ExamType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTypeRepository extends ReactiveMongoRepository<ExamType, String> {
}

package org.khasanof.classroomservice.repository.grade;

import org.khasanof.classroomservice.domain.grade.Grade;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends MongoRepository<Grade, String>, BaseRepository {
}

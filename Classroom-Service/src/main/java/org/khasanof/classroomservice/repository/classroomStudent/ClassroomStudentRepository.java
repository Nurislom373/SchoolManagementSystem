package org.khasanof.classroomservice.repository.classroomStudent;

import org.khasanof.classroomservice.domain.classroomStudent.ClassroomStudent;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomStudentRepository extends MongoRepository<ClassroomStudent, String>, BaseRepository {
}

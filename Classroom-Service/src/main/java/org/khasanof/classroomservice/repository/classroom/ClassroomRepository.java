package org.khasanof.classroomservice.repository.classroom;

import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends MongoRepository<Classroom, String>, BaseRepository {
}

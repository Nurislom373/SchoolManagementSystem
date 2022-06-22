package org.khasanof.authservice.repository.teacher;

import org.khasanof.authservice.entity.teacher.Teacher;
import org.khasanof.authservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String>, BaseRepository {

    @Transactional
    void deleteById(String id);
}

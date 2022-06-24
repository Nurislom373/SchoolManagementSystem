package org.khasanof.authservice.repository.student;

import org.khasanof.authservice.entity.student.Student;
import org.khasanof.authservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>, BaseRepository {

    @Transactional
    void deleteById(String id);

    Optional<Student> findByEmail(String email);
}

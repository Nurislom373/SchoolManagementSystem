package org.khasanof.authservice.repository.parent;

import org.khasanof.authservice.entity.parent.Parent;
import org.khasanof.authservice.entity.student.Student;
import org.khasanof.authservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String>, BaseRepository {

    @Transactional
    void deleteById(String id);

    Optional<Parent> findByEmail(String email);
}

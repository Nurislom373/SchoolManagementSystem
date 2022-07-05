package org.khasanof.authservice.repository.auth;

import org.khasanof.authservice.entity.auth.AuthUser;
import org.khasanof.authservice.repository.BaseRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String>, BaseRepository {
    Optional<AuthUser> findByEmailAndRoleEquals(String email, String role);
}

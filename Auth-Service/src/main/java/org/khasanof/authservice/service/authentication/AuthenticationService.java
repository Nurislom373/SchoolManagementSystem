package org.khasanof.authservice.service.authentication;

import lombok.RequiredArgsConstructor;
import org.khasanof.authservice.entity.parent.Parent;
import org.khasanof.authservice.entity.student.Student;
import org.khasanof.authservice.entity.teacher.Teacher;
import org.khasanof.authservice.enums.authentication.LoginEnums;
import org.khasanof.authservice.repository.parent.ParentRepository;
import org.khasanof.authservice.repository.student.StudentRepository;
import org.khasanof.authservice.repository.teacher.TeacherRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ParentRepository parentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<String> tokenizer = Collections.list(new StringTokenizer(username, ":")).stream()
                .map(token -> (String) token).toList();
        return checkUserType(tokenizer.get(1), tokenizer.get(0));
    }

    private UserDetails checkUserType(String type, String email) {
        if (Objects.nonNull(type)) {
            return switch (LoginEnums.valueOf(type.toUpperCase())) {
                case STUDENT -> studentGet(email);
                case TEACHER -> teacherGet(email);
                case PARENT -> parentGet(email);
            };
        } else {
            throw new RuntimeException("Type is Null");
        }
    }

    private UserDetails studentGet(String email) {
        Student user = studentRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }

    private UserDetails teacherGet(String email) {
        Teacher user = teacherRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }

    private UserDetails parentGet(String email) {
        Parent user = parentRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }
}

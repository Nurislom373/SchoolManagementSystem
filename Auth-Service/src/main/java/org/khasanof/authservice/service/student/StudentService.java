package org.khasanof.authservice.service.student;

import org.khasanof.authservice.config.encryptions.PasswordEncoderConfigurer;
import org.khasanof.authservice.criteria.student.StudentCriteria;
import org.khasanof.authservice.dto.student.StudentCreateDTO;
import org.khasanof.authservice.dto.student.StudentDetailDTO;
import org.khasanof.authservice.dto.student.StudentGetDTO;
import org.khasanof.authservice.dto.student.StudentUpdateDTO;
import org.khasanof.authservice.entity.student.Student;
import org.khasanof.authservice.mapper.student.StudentMapper;
import org.khasanof.authservice.repository.student.StudentRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.validator.student.StudentValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StudentService extends AbstractService<StudentRepository, StudentMapper, StudentValidator> {
    public StudentService(StudentRepository repository, StudentMapper mapper, StudentValidator validator) {
        super(repository, mapper, validator);
    }

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Async
    public void create(StudentCreateDTO dto) {
        validator.validOnCreate(dto);
        dto.setPassword(new PasswordEncoderConfigurer().passwordEncoder().encode(dto.getPassword()));
        logger.info("create student with -> " + Thread.currentThread().getName());
        repository.save(mapper.toCreateDTO(dto));
    }

    @Async
    public void update(StudentUpdateDTO dto) {
        validator.validOnUpdate(dto);
        logger.info("update student with -> " + Thread.currentThread().getName());
        Optional<Student> optional = repository.findById(dto.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException("Auth block not found");
        }
        Student student = optional.get();
        BeanUtils.copyProperties(dto, student, "id", "dateOfJoin", "password");
        repository.save(student);
    }

    @Async
    public void delete(String id) {
        validator.validateKey(id);
        logger.info("delete student with -> " + Thread.currentThread().getName());
        Optional<Student> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Auth block not found");
        }
        repository.deleteById(id);
    }

    @Async
    public CompletableFuture<StudentGetDTO> get(String id) {
        validator.validateKey(id);
        logger.info("get student with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromGetDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Auth block not found"))));
    }

    @Async
    public CompletableFuture<StudentDetailDTO> detail(String id) {
        validator.validateKey(id);
        logger.info("detail student with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromDetailDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Auth block not found"))));
    }

    @Async
    public CompletableFuture<List<StudentGetDTO>> list(StudentCriteria criteria) {
        logger.info("list student with -> " + Thread.currentThread().getName());
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return CompletableFuture.completedFuture(mapper.fromGetListDTO(repository.findAll(request).toList()));
    }
}

package org.khasanof.authservice.service.teacher;

import org.khasanof.authservice.criteria.teacher.TeacherCriteria;
import org.khasanof.authservice.dto.teacher.TeacherCreateDTO;
import org.khasanof.authservice.dto.teacher.TeacherDetailDTO;
import org.khasanof.authservice.dto.teacher.TeacherGetDTO;
import org.khasanof.authservice.dto.teacher.TeacherUpdateDTO;
import org.khasanof.authservice.entity.teacher.Teacher;
import org.khasanof.authservice.mapper.teacher.TeacherMapper;
import org.khasanof.authservice.repository.teacher.TeacherRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.validator.teacher.TeacherValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TeacherService extends AbstractService<TeacherRepository, TeacherMapper, TeacherValidator> {

    public TeacherService(TeacherRepository repository, TeacherMapper mapper, TeacherValidator validator) {
        super(repository, mapper, validator);
    }

    Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Async
    public void create(TeacherCreateDTO dto) {
        validator.validOnCreate(dto);
        logger.info("create teacher with -> " + Thread.currentThread().getName());
        repository.save(mapper.toCreateDTO(dto));
    }

    @Async
    public void update(TeacherUpdateDTO dto) {
        validator.validOnUpdate(dto);
        logger.info("update teacher with -> " + Thread.currentThread().getName());
        Optional<Teacher> optional = repository.findById(dto.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException("Teacher not found");
        }
        Teacher teacher = optional.get();
        BeanUtils.copyProperties(dto, teacher, "id", "dateOfJoin", "password");
        repository.save(teacher);
    }

    @Async
    public void delete(String id) {
        validator.validateKey(id);
        logger.info("delete teacher with -> " + Thread.currentThread().getName());
        Optional<Teacher> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Teacher not found");
        }
        repository.deleteById(id);
    }

    @Async
    public CompletableFuture<TeacherGetDTO> get(String id) {
        validator.validateKey(id);
        logger.info("get teacher with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromGetDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found"))));
    }

    @Async
    public CompletableFuture<TeacherDetailDTO> detail(String id) {
        validator.validateKey(id);
        logger.info("detail teacher with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromDetailDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found"))));
    }

    @Async
    public CompletableFuture<List<TeacherGetDTO>> list(TeacherCriteria criteria) {
        logger.info("list teacher with -> " + Thread.currentThread().getName());
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return CompletableFuture.completedFuture(mapper.fromGetListDTO(repository.findAll(request).toList()));
    }

}

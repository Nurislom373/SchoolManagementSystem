package org.khasanof.authservice.service.teacher;

import org.khasanof.authservice.mapper.teacher.TeacherMapper;
import org.khasanof.authservice.repository.teacher.TeacherRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.validator.teacher.TeacherValidator;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends AbstractService<TeacherRepository, TeacherMapper, TeacherValidator> {

    public TeacherService(TeacherRepository repository, TeacherMapper mapper, TeacherValidator validator) {
        super(repository, mapper, validator);
    }

}

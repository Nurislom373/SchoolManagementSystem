package org.khasanof.authservice.validator.teacher;

import org.khasanof.authservice.dto.teacher.TeacherCreateDTO;
import org.khasanof.authservice.dto.teacher.TeacherUpdateDTO;
import org.khasanof.authservice.exception.exceptions.InvalidValidationException;
import org.khasanof.authservice.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeacherValidator extends AbstractValidator<TeacherCreateDTO, TeacherUpdateDTO, String> {
    @Override
    public void validOnCreate(TeacherCreateDTO teacherCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(teacherCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(TeacherUpdateDTO teacherUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(teacherUpdateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }
}

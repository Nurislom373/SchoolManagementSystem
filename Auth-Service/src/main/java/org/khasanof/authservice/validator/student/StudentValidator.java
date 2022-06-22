package org.khasanof.authservice.validator.student;

import org.khasanof.authservice.dto.student.StudentCreateDTO;
import org.khasanof.authservice.dto.student.StudentUpdateDTO;
import org.khasanof.authservice.exception.exceptions.InvalidValidationException;
import org.khasanof.authservice.validator.AbstractValidator;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator extends AbstractValidator<StudentCreateDTO, StudentUpdateDTO, String> {
    @Override
    public void validOnCreate(StudentCreateDTO studentCreateDTO) throws InvalidValidationException {

    }

    @Override
    public void validOnUpdate(StudentUpdateDTO studentUpdateDTO) throws InvalidValidationException {

    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {

    }
}

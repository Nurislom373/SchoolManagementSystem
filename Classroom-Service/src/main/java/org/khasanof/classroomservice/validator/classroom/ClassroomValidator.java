package org.khasanof.classroomservice.validator.classroom;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.validator.AbstractValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.springframework.stereotype.Component;

@Component
public class ClassroomValidator extends AbstractValidator<ClassroomCreateVO, ClassroomUpdateVO, String> {
    @Override
    public void validOnCreate(ClassroomCreateVO cd) throws InvalidValidationException {

    }

    @Override
    public void validOnUpdate(ClassroomUpdateVO ud) throws InvalidValidationException {

    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {

    }
}

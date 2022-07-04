package org.khasanof.classroomservice.validator.classroomStudent;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.validator.AbstractValidator;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentCreateVO;
import org.springframework.stereotype.Component;

@Component
public class ClassroomStudentValidator extends AbstractValidator<ClassroomStudentCreateVO, GenericVO, String> {
    @Override
    public void validOnCreate(ClassroomStudentCreateVO cd) throws InvalidValidationException {

    }

    @Override
    public void validOnUpdate(GenericVO ud) throws InvalidValidationException {

    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {

    }
}

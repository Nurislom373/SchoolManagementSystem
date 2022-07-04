package org.khasanof.classroomservice.validator.grade;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.validator.AbstractValidator;
import org.khasanof.classroomservice.vo.grade.GradeCreateVO;
import org.khasanof.classroomservice.vo.grade.GradeUpdateVO;
import org.springframework.stereotype.Component;

@Component
public class GradeValidator extends AbstractValidator<GradeCreateVO, GradeUpdateVO, String> {

    @Override
    public void validOnCreate(GradeCreateVO cd) throws InvalidValidationException {

    }

    @Override
    public void validOnUpdate(GradeUpdateVO ud) throws InvalidValidationException {

    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {

    }
}

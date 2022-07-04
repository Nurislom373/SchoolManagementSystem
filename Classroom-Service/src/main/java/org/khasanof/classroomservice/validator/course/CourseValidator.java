package org.khasanof.classroomservice.validator.course;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.validator.AbstractValidator;
import org.khasanof.classroomservice.vo.course.CourseCreateVO;
import org.khasanof.classroomservice.vo.course.CourseUpdateVO;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator extends AbstractValidator<CourseCreateVO, CourseUpdateVO, String> {
    @Override
    public void validOnCreate(CourseCreateVO cd) throws InvalidValidationException {

    }

    @Override
    public void validOnUpdate(CourseUpdateVO ud) throws InvalidValidationException {

    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {

    }
}

package org.khasanof.classroomservice.validator.classroom;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.validator.AbstractValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClassroomValidator extends AbstractValidator<ClassroomCreateVO, ClassroomUpdateVO, String> {
    @Override
    public void validOnCreate(ClassroomCreateVO cd) throws InvalidValidationException {
        if (Objects.isNull(cd)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(ClassroomUpdateVO ud) throws InvalidValidationException {
        if (Objects.isNull(ud)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }

    public void validateKeyValue(String key, String value) throws InvalidValidationException {
        if (Objects.isNull(key) || Objects.isNull(value)) {
            throw new InvalidValidationException("Parameter is null");
        }
    }

    public void validateKeyMinMax(String key, Integer min, Integer max) throws InvalidValidationException {
        if (Objects.isNull(key) || Objects.isNull(min) || Objects.isNull(max)) {
            throw new InvalidValidationException("Parameter is null");
        }
    }

}

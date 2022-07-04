package org.khasanof.classroomservice.validator;

import org.khasanof.classroomservice.exception.exceptions.InvalidValidationException;
import org.khasanof.classroomservice.vo.BaseVO;
import org.khasanof.classroomservice.vo.GenericVO;

import java.io.Serializable;

public abstract class AbstractValidator<CV extends BaseVO, UV extends GenericVO, K extends Serializable> implements BaseValidator {
    public abstract void validOnCreate(CV cd) throws InvalidValidationException;

    public abstract void validOnUpdate(UV ud) throws InvalidValidationException;

    public abstract void validateKey(K id) throws InvalidValidationException;
}

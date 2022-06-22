package org.khasanof.authservice.validator;

import org.khasanof.authservice.dto.BaseDTO;
import org.khasanof.authservice.dto.GenericDTO;
import org.khasanof.authservice.exception.exceptions.InvalidValidationException;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> implements BaseValidator {
    public abstract void validOnCreate(CD cd) throws InvalidValidationException;

    public abstract void validOnUpdate(UD ud) throws InvalidValidationException;

    public abstract void validateKey(K id) throws InvalidValidationException;
}

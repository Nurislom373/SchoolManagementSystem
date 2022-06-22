package org.khasanof.authservice.validator.parent;

import org.khasanof.authservice.dto.parent.ParentCreateDTO;
import org.khasanof.authservice.dto.parent.ParentUpdateDTO;
import org.khasanof.authservice.exception.exceptions.InvalidValidationException;
import org.khasanof.authservice.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ParentValidator extends AbstractValidator<ParentCreateDTO, ParentUpdateDTO, String> {
    @Override
    public void validOnCreate(ParentCreateDTO parentCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(parentCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(ParentUpdateDTO parentUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(parentUpdateDTO)) {
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

package org.khasanof.authservice.validator.auth;

import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.auth.AuthUserUpdateDTO;
import org.khasanof.authservice.exception.exceptions.InvalidValidationException;
import org.khasanof.authservice.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDTO, AuthUserUpdateDTO, String> {
    @Override
    public void validOnCreate(AuthUserCreateDTO authUserCreateDTO) throws InvalidValidationException {
        if (Objects.isNull(authUserCreateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(AuthUserUpdateDTO authUserUpdateDTO) throws InvalidValidationException {
        if (Objects.isNull(authUserUpdateDTO)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validateKey(String id) throws InvalidValidationException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }

    public void validateOnRequest(AuthUserRequestDTO dto) {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
    }
}

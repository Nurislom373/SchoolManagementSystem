package org.khasanof.authservice.service.auth;

import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.token.TokenDTO;
import org.khasanof.authservice.service.BaseService;

public interface AuthUserService extends BaseService {
    TokenDTO login(AuthUserRequestDTO dto);

    void register(AuthUserCreateDTO dto);
}

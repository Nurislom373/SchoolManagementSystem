package org.khasanof.authservice.mapper.auth;

import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserDetailDTO;
import org.khasanof.authservice.dto.auth.AuthUserGetDTO;
import org.khasanof.authservice.dto.auth.AuthUserUpdateDTO;
import org.khasanof.authservice.entity.auth.AuthUser;
import org.khasanof.authservice.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUserDetailDTO, AuthUser> {
}

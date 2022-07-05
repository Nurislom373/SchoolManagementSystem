package org.khasanof.authservice.service.auth;

import com.auth0.jwt.JWT;
import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.token.TokenDTO;
import org.khasanof.authservice.entity.auth.AuthUser;
import org.khasanof.authservice.enums.authentication.LoginEnums;
import org.khasanof.authservice.mapper.auth.AuthUserMapper;
import org.khasanof.authservice.repository.auth.AuthUserRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.utils.BaseUtils;
import org.khasanof.authservice.utils.jwt.JwtUtils;
import org.khasanof.authservice.validator.auth.AuthUserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator> implements AuthUserService {

    Logger logger = LoggerFactory.getLogger(AuthUserServiceImpl.class);


    public AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public TokenDTO login(AuthUserRequestDTO dto) {
        validator.validateOnRequest(dto);
        if (checkHasRole(dto.getRole())) {
            AuthUser authUser = repository.findByEmailAndRoleEquals(dto.getEmail(), dto.getRole()).orElseThrow(() -> {
                throw new NotFoundException("User not found");
            });
            if (BaseUtils.ENCODER.matches(dto.getPassword(), authUser.getPassword())) {

                Date expiryForAccessToken = JwtUtils.getExpiry();
                Date expiryForRefreshToken = JwtUtils.getExpiryForRefreshToken();

                String accessToken = JWT.create()
                        .withSubject(authUser.getEmail())
                        .withExpiresAt(expiryForAccessToken)
                        .sign(JwtUtils.getAlgorithm());

                String refreshToken = JWT.create()
                        .withSubject(authUser.getEmail())
                        .withExpiresAt(expiryForRefreshToken)
                        .sign(JwtUtils.getAlgorithm());

                logger.info("successfully match password");

                return TokenDTO.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
            } else {
                logger.error("Password is invalid : " + dto.getPassword());
                throw new RuntimeException("Password is invalid");
            }
        } else {
            logger.error("Role is invalid : " + dto.getRole());
            throw new RuntimeException("Role is Invalid");
        }
    }

    @Override
    public void register(AuthUserCreateDTO dto) {
        validator.validOnCreate(dto);
        if (checkHasRole(dto.getRole())) {
            dto.setPassword(BaseUtils.ENCODER.encode(dto.getPassword()));
            AuthUser authUser = mapper.toCreateDTO(dto);
            repository.save(authUser);
            logger.info("create user with -> " + Thread.currentThread().getName());
        } else {
            logger.error("Role is invalid : " + dto.getRole());
            throw new RuntimeException("Role is invalid");
        }
    }

    private boolean checkHasRole(String role) {
        return LoginEnums.checkRole(role);
    }

}

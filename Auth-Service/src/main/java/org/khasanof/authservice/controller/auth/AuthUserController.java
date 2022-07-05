package org.khasanof.authservice.controller.auth;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.token.TokenDTO;
import org.khasanof.authservice.response.Data;
import org.khasanof.authservice.service.auth.AuthUserService;
import org.khasanof.authservice.service.auth.AuthUserServiceImpl;
import org.khasanof.authservice.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Data<TokenDTO>> login(@RequestBody AuthUserRequestDTO dto) {
        return new ResponseEntity<>(new Data<>(service.login(dto)), HttpStatus.OK);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> register(@RequestBody AuthUserCreateDTO dto) {
        service.register(dto);
        return new ResponseEntity<>(new Data<>("Successfully Registered"), HttpStatus.OK);
    }
}

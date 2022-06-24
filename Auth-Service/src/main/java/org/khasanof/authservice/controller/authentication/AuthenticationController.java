package org.khasanof.authservice.controller.authentication;

import org.khasanof.authservice.dto.authentication.LoginDTO;
import org.khasanof.authservice.utils.BaseUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/*")
public class AuthenticationController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginDTO dto) {
        HttpEntity<LoginDTO> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = BaseUtils.REST_TEMPLATE.exchange("http://localhost:8800/api//login", HttpMethod.POST, entity, Object.class);
        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);
    }
}

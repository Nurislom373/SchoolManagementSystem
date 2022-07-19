package org.khasanof.authservice.controller.auth;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.criteria.auth.AuthUserCriteria;
import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserGetDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.student.StudentGetDTO;
import org.khasanof.authservice.dto.teacher.TeacherGetDTO;
import org.khasanof.authservice.dto.token.TokenDTO;
import org.khasanof.authservice.response.Data;
import org.khasanof.authservice.service.auth.AuthUserService;
import org.khasanof.authservice.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value = "/get/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<StudentGetDTO>> studentGet(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.studentGet(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "get/teacher/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TeacherGetDTO>> teacherGet(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.teacherGet(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list(@Valid AuthUserCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}

package org.khasanof.authservice.service.auth;

import org.khasanof.authservice.criteria.auth.AuthUserCriteria;
import org.khasanof.authservice.dto.auth.AuthUserCreateDTO;
import org.khasanof.authservice.dto.auth.AuthUserGetDTO;
import org.khasanof.authservice.dto.auth.AuthUserRequestDTO;
import org.khasanof.authservice.dto.student.StudentGetDTO;
import org.khasanof.authservice.dto.teacher.TeacherGetDTO;
import org.khasanof.authservice.dto.token.TokenDTO;
import org.khasanof.authservice.service.BaseService;

import java.util.List;

public interface AuthUserService extends BaseService {
    TokenDTO login(AuthUserRequestDTO dto);

    void register(AuthUserCreateDTO dto);

    StudentGetDTO studentGet(String id);

    TeacherGetDTO teacherGet(String id);

    List<AuthUserGetDTO> list(AuthUserCriteria criteria);
}

package org.khasanof.authservice.controller.teacher;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.service.teacher.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teacher/*")
public class TeacherController extends AbstractController<TeacherService> {

    public TeacherController(TeacherService service) {
        super(service);
    }
}

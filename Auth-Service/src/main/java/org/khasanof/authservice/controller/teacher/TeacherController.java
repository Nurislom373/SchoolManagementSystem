package org.khasanof.authservice.controller.teacher;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.criteria.student.StudentCriteria;
import org.khasanof.authservice.criteria.teacher.TeacherCriteria;
import org.khasanof.authservice.dto.student.StudentCreateDTO;
import org.khasanof.authservice.dto.student.StudentDetailDTO;
import org.khasanof.authservice.dto.student.StudentGetDTO;
import org.khasanof.authservice.dto.student.StudentUpdateDTO;
import org.khasanof.authservice.dto.teacher.TeacherCreateDTO;
import org.khasanof.authservice.dto.teacher.TeacherDetailDTO;
import org.khasanof.authservice.dto.teacher.TeacherGetDTO;
import org.khasanof.authservice.dto.teacher.TeacherUpdateDTO;
import org.khasanof.authservice.response.Data;
import org.khasanof.authservice.service.teacher.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/teacher/*")
public class TeacherController extends AbstractController<TeacherService> {

    public TeacherController(TeacherService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody TeacherCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Teacher"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody TeacherUpdateDTO dto) {
        service.update(dto);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Teacher"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Teacher"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TeacherGetDTO>> get(@PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.get(id).get()), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<TeacherDetailDTO>> detail(@PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.detail(id).get()), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<TeacherGetDTO>>> list(@Valid TeacherCriteria criteria) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.list(criteria).get()), HttpStatus.OK);
    }
}

package org.khasanof.classroomservice.controller.course;

import org.khasanof.classroomservice.controller.AbstractController;
import org.khasanof.classroomservice.criteria.course.CourseCriteria;
import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.service.course.CourseService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.vo.course.CourseCreateVO;
import org.khasanof.classroomservice.vo.course.CourseDetailVO;
import org.khasanof.classroomservice.vo.course.CourseGetVO;
import org.khasanof.classroomservice.vo.course.CourseUpdateVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course/*")
public class CourseController extends AbstractController<CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody CourseCreateVO vo) {
        service.create(vo);
        return new ResponseEntity<>(new Data<>("Successfully Created - Course"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody CourseUpdateVO vo) {
        service.update(vo);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Course"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Course"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<CourseGetVO>> get(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<CourseDetailVO>> detail(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<CourseGetVO>>> list(@Valid CourseCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}

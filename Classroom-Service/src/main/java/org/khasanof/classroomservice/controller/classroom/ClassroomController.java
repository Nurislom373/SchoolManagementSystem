package org.khasanof.classroomservice.controller.classroom;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.khasanof.classroomservice.controller.AbstractController;
import org.khasanof.classroomservice.criteria.classroom.ClassroomCriteria;
import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.service.classroom.ClassroomService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomDetailVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/classroom/*")
public class ClassroomController extends AbstractController<ClassroomService> {

    private static final String AUTH_SERVICE = "authService";

    public ClassroomController(ClassroomService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody ClassroomCreateVO vo) {
        service.create(vo);
        return new ResponseEntity<>(new Data<>("Successfully Created - Classroom"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody ClassroomUpdateVO vo) {
        service.update(vo);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Classroom"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Classroom"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<ClassroomGetVO>> get(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    @CircuitBreaker(name = AUTH_SERVICE, fallbackMethod = "getDetail")
    public ResponseEntity<Data<ClassroomDetailVO>> detail(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    public ResponseEntity<Data<ClassroomDetailVO>> getDetail(Exception e) {
        ClassroomDetailVO detailVO = new ClassroomDetailVO();
        detailVO.setTeacher(null);
        detailVO.setRemarks("hello world");
        detailVO.setSection("A");
        detailVO.setStatus(false);
        detailVO.setGradeId("11");
        detailVO.setId("1");
        detailVO.setYear(2004);
        return new ResponseEntity<>(new Data<>(detailVO), HttpStatus.OK);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<ClassroomGetVO>>> list(@Valid ClassroomCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}

package org.khasanof.classroomservice.controller.classroomStudent;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.khasanof.classroomservice.controller.AbstractController;
import org.khasanof.classroomservice.criteria.classroomStudent.ClassroomStudentCriteria;
import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.service.classroomStudent.ClassroomStudentService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentCreateVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentDetailVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentGetVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/classroomStudent/*")
public class ClassroomStudentController extends AbstractController<ClassroomStudentService> {

    private int attempt = 1;

    public ClassroomStudentController(ClassroomStudentService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody ClassroomStudentCreateVO vo) {
        service.create(vo);
        return new ResponseEntity<>(new Data<>("Successfully Created - Classroom Student"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Classroom Student"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/userId={id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> deleteUserId(@PathVariable String id) {
        service.deleteUserId(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Classroom Student"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<ClassroomStudentGetVO>> get(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    @Retry(name = BaseUtils.AUTH_SERVICE, fallbackMethod = "failMethod")
    public ResponseEntity<Data<ClassroomStudentDetailVO>> detail(@PathVariable String id) {
        System.out.println("retry method called " + attempt++ + " times " + " at " + new Date());
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<ClassroomStudentGetVO>>> list(@Valid ClassroomStudentCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria), service.count()), HttpStatus.OK);
    }

    @RequestMapping(value = "list/classroom={id}", method = RequestMethod.GET)
    public ResponseEntity<Data<List<ClassroomStudentGetVO>>> list(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.list(id), service.count()), HttpStatus.OK);
    }

    public ResponseEntity<Data<String>> failMethod(Exception e) {
        return new ResponseEntity<>(new Data<>("Server is down!!!"), HttpStatus.OK);
    }
}

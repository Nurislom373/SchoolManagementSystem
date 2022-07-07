package org.khasanof.classroomservice.controller.grade;

import org.khasanof.classroomservice.controller.AbstractController;
import org.khasanof.classroomservice.criteria.grade.GradeCriteria;
import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.service.grade.GradeService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.vo.grade.GradeCreateVO;
import org.khasanof.classroomservice.vo.grade.GradeGetVO;
import org.khasanof.classroomservice.vo.grade.GradeUpdateVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/grade/*")
public class GradeController extends AbstractController<GradeService> {

    public GradeController(GradeService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody GradeCreateVO vo) {
        service.create(vo);
        return new ResponseEntity<>(new Data<>("Successfully Created - Grade"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody GradeUpdateVO vo) {
        service.update(vo);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Grade"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Grade"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<GradeGetVO>> get(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<GradeGetVO>>> list(@Valid GradeCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}

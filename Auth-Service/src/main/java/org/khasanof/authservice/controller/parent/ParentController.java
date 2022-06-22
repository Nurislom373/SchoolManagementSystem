package org.khasanof.authservice.controller.parent;

import org.khasanof.authservice.controller.AbstractController;
import org.khasanof.authservice.criteria.parent.ParentCriteria;
import org.khasanof.authservice.criteria.student.StudentCriteria;
import org.khasanof.authservice.dto.parent.ParentCreateDTO;
import org.khasanof.authservice.dto.parent.ParentDetailDTO;
import org.khasanof.authservice.dto.parent.ParentGetDTO;
import org.khasanof.authservice.dto.parent.ParentUpdateDTO;
import org.khasanof.authservice.response.Data;
import org.khasanof.authservice.service.parent.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/parent/*")
public class ParentController extends AbstractController<ParentService> {

    public ParentController(ParentService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody ParentCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Parent"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody ParentUpdateDTO dto) {
        service.update(dto);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Parent"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully deleted - Parent"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<ParentGetDTO>> get(@PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.get(id).get()), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<ParentDetailDTO>> detail(@PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.detail(id).get()), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<ParentGetDTO>>> list(@Valid ParentCriteria criteria) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(new Data<>(service.list(criteria).get()), HttpStatus.OK);
    }
}

package org.khasanof.attendanceservice.controller.attendance;

import lombok.RequiredArgsConstructor;
import org.khasanof.attendanceservice.criteria.AttendanceCriteria;
import org.khasanof.attendanceservice.dto.attendance.AttendanceCreateDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceDetailDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceGetDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceUpdateDTO;
import org.khasanof.attendanceservice.response.Data;
import org.khasanof.attendanceservice.service.attendance.AttendanceService;
import org.khasanof.attendanceservice.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = BaseUtils.PATH + "/attendance/*")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService service;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Data<String>> create(@RequestBody AttendanceCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(new Data<>("Successfully Created - Attendance"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Data<String>> update(@RequestBody AttendanceUpdateDTO dto) {
        service.update(dto);
        return new ResponseEntity<>(new Data<>("Successfully Updated - Attendance"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Attendance"), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/userId={id}", method = RequestMethod.DELETE)
    public ResponseEntity<Data<String>> deleteUser(@PathVariable String id) {
        service.deleteUser(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - Attendance"), HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AttendanceGetDTO>> get(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AttendanceDetailDTO>> detail(@PathVariable String id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<Data<List<AttendanceGetDTO>>> list(@Valid AttendanceCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @RequestMapping(value = "list/status={status}", method = RequestMethod.GET)
    public ResponseEntity<Data<List<AttendanceGetDTO>>> list(@PathVariable String status) {
        return new ResponseEntity<>(new Data<>(service.list(status)), HttpStatus.OK);
    }

}

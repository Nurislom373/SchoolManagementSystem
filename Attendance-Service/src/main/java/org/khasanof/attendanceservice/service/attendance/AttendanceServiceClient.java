package org.khasanof.attendanceservice.service.attendance;

import org.khasanof.attendanceservice.dto.student.StudentDTO;
import org.khasanof.attendanceservice.response.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AttendanceServiceClient", url = "http://localhost:8800", path = "/api/v1/auth")
public interface AttendanceServiceClient {

    @GetMapping("get/student/{id}")
    Data<StudentDTO> get(@PathVariable String id);
}

package org.khasanof.classroomservice.service.classroomStudent;

import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.vo.student.StudentGetVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ClassroomStudentServiceClient", url = "http://localhost:8800", path = "/api/v1/auth")
public interface ClassroomStudentServiceClient {

    @GetMapping("/get/student/{id}")
    Data<StudentGetVO> get(@PathVariable String id);
}

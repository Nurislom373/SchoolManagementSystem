package org.khasanof.classroomservice.service.classroom;

import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.vo.teacher.TeacherGetVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ClassroomServiceClient", url = "http://localhost:8800", path = "/teacher")
public interface ClassroomServiceClient {

    @GetMapping("/get/{id}")
    Data<TeacherGetVO> get(@PathVariable String id);
}

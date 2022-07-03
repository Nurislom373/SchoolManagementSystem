package org.khasanof.examservice.examResult.client;

import org.khasanof.examservice.examResult.dto.StudentGetDTO;
import org.khasanof.examservice.response.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ExamResultServiceClient", url = "http://localhost:8800", path = "/student")
public interface ExamResultServiceClient {

    @GetMapping("/get/{id}")
    StudentGetDTO get(@PathVariable String id);
}

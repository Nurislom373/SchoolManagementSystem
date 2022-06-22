package org.khasanof.authservice.mapper.student;


import org.khasanof.authservice.dto.student.StudentCreateDTO;
import org.khasanof.authservice.dto.student.StudentDetailDTO;
import org.khasanof.authservice.dto.student.StudentGetDTO;
import org.khasanof.authservice.dto.student.StudentUpdateDTO;
import org.khasanof.authservice.entity.student.Student;
import org.khasanof.authservice.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<StudentCreateDTO, StudentUpdateDTO, StudentGetDTO, StudentDetailDTO, Student> {
}

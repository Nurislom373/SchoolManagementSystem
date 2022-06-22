package org.khasanof.authservice.mapper.teacher;

import org.khasanof.authservice.dto.teacher.TeacherCreateDTO;
import org.khasanof.authservice.dto.teacher.TeacherDetailDTO;
import org.khasanof.authservice.dto.teacher.TeacherGetDTO;
import org.khasanof.authservice.dto.teacher.TeacherUpdateDTO;
import org.khasanof.authservice.entity.teacher.Teacher;
import org.khasanof.authservice.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TeacherMapper extends GenericMapper<TeacherCreateDTO, TeacherUpdateDTO, TeacherGetDTO, TeacherDetailDTO, Teacher> {
}

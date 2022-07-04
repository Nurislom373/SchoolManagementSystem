package org.khasanof.classroomservice.mapper.classroom;

import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.mapper.GenericMapper;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomDetailVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClassroomMapper extends GenericMapper<ClassroomCreateVO, ClassroomUpdateVO, ClassroomGetVO, ClassroomDetailVO, Classroom> {
}

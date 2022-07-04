package org.khasanof.classroomservice.mapper.classroomStudent;

import org.khasanof.classroomservice.domain.classroomStudent.ClassroomStudent;
import org.khasanof.classroomservice.mapper.GenericMapper;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentCreateVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentDetailVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentGetVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClassroomStudentMapper extends GenericMapper<ClassroomStudentCreateVO, GenericVO, ClassroomStudentGetVO, ClassroomStudentDetailVO, ClassroomStudent> {
}

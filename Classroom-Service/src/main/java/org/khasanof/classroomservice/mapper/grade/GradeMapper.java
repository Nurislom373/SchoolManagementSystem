package org.khasanof.classroomservice.mapper.grade;

import org.khasanof.classroomservice.domain.grade.Grade;
import org.khasanof.classroomservice.mapper.GenericMapper;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.grade.GradeCreateVO;
import org.khasanof.classroomservice.vo.grade.GradeGetVO;
import org.khasanof.classroomservice.vo.grade.GradeUpdateVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GradeMapper extends GenericMapper<GradeCreateVO, GradeUpdateVO, GradeGetVO, GenericVO, Grade> {
}

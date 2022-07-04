package org.khasanof.classroomservice.mapper.course;

import org.khasanof.classroomservice.domain.course.Course;
import org.khasanof.classroomservice.mapper.GenericMapper;
import org.khasanof.classroomservice.vo.course.CourseCreateVO;
import org.khasanof.classroomservice.vo.course.CourseDetailVO;
import org.khasanof.classroomservice.vo.course.CourseGetVO;
import org.khasanof.classroomservice.vo.course.CourseUpdateVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<CourseCreateVO, CourseUpdateVO, CourseGetVO, CourseDetailVO, Course> {
}

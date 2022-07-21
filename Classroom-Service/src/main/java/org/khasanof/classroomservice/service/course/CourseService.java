package org.khasanof.classroomservice.service.course;

import org.khasanof.classroomservice.criteria.course.CourseCriteria;
import org.khasanof.classroomservice.domain.course.Course;
import org.khasanof.classroomservice.mapper.course.CourseMapper;
import org.khasanof.classroomservice.repository.course.CourseRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.service.grade.GradeService;
import org.khasanof.classroomservice.validator.course.CourseValidator;
import org.khasanof.classroomservice.vo.course.CourseCreateVO;
import org.khasanof.classroomservice.vo.course.CourseDetailVO;
import org.khasanof.classroomservice.vo.course.CourseGetVO;
import org.khasanof.classroomservice.vo.course.CourseUpdateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class CourseService extends AbstractService<CourseRepository, CourseMapper, CourseValidator> {
    private final GradeService gradeService;

    public CourseService(CourseRepository repository, CourseMapper mapper, CourseValidator validator, GradeService gradeService) {
        super(repository, mapper, validator);
        this.gradeService = gradeService;
    }

    public void create(CourseCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
    }

    public void update(CourseUpdateVO vo) {
        validator.validOnUpdate(vo);
        Course course = repository.findById(vo.getId()).orElseThrow(() -> {
            throw new NotFoundException("Course not found");
        });
        BeanUtils.copyProperties(vo, course, "id", "gradeId");
        repository.save(course);
    }

    public void delete(String id) {
        validator.validateKey(id);
        repository.delete(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Course not found");
        }));
    }

    public CourseGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Course not found");
        }));
    }

    public CourseDetailVO detail(String id) {
        validator.validateKey(id);
        Course course = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Course not found");
        });
        CourseDetailVO courseDetailVO = mapper.fromDetailVO(course);
        courseDetailVO.setGrade(gradeService.get(course.getGradeId()));
        return courseDetailVO;
    }

    public List<CourseGetVO> list(CourseCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }

    public List<CourseGetVO> list(String gradeId) {
        return mapper.fromGetListVO(repository.findAllByGradeIdEquals(gradeId));
    }

    public Long count() {
        return repository.count();
    }
}

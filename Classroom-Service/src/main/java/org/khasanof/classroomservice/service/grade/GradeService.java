package org.khasanof.classroomservice.service.grade;

import org.khasanof.classroomservice.criteria.grade.GradeCriteria;
import org.khasanof.classroomservice.domain.grade.Grade;
import org.khasanof.classroomservice.mapper.grade.GradeMapper;
import org.khasanof.classroomservice.repository.grade.GradeRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.service.classroom.ClassroomService;
import org.khasanof.classroomservice.service.course.CourseService;
import org.khasanof.classroomservice.validator.grade.GradeValidator;
import org.khasanof.classroomservice.vo.grade.GradeCreateVO;
import org.khasanof.classroomservice.vo.grade.GradeGetVO;
import org.khasanof.classroomservice.vo.grade.GradeUpdateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class GradeService extends AbstractService<GradeRepository, GradeMapper, GradeValidator> {

    private final CourseService courseService;
    private final ClassroomService classroomService;

    public GradeService(GradeRepository repository, GradeMapper mapper, GradeValidator validator, CourseService courseService, ClassroomService classroomService) {
        super(repository, mapper, validator);
        this.courseService = courseService;
        this.classroomService = classroomService;
    }

    public void create(GradeCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
    }

    public void update(GradeUpdateVO vo) {
        validator.validOnUpdate(vo);
        Grade grade = repository.findById(vo.getId()).orElseThrow(() -> {
            throw new NotFoundException("Grade not found");
        });
        BeanUtils.copyProperties(vo, grade, "id");
        repository.save(grade);
    }

    public void delete(String id) {
        validator.validateKey(id);
        Grade grade = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Grade not found");
        });
        courseService.deleteGradeId(grade.getId());
        classroomService.deleteGradeId(grade.getId());
        repository.delete(grade);
    }

    public GradeGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Grade not found");
        }));
    }

    public List<GradeGetVO> list(GradeCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }
}

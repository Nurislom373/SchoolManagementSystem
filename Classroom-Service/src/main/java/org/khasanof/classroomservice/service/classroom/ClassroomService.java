package org.khasanof.classroomservice.service.classroom;

import org.khasanof.classroomservice.criteria.classroom.ClassroomCriteria;
import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.mapper.classroom.ClassroomMapper;
import org.khasanof.classroomservice.repository.classroom.ClassroomRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.service.classroomStudent.ClassroomStudentService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.validator.classroom.ClassroomValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomDetailVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.khasanof.classroomservice.vo.teacher.TeacherGetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService extends AbstractService<ClassroomRepository, ClassroomMapper, ClassroomValidator> {

    private final ClassroomServiceClient client;
    private final ClassroomStudentService studentService;

    public ClassroomService(ClassroomRepository repository, ClassroomMapper mapper, ClassroomValidator validator, ClassroomServiceClient client, ClassroomStudentService studentService) {
        super(repository, mapper, validator);
        this.client = client;
        this.studentService = studentService;
    }

    public void create(ClassroomCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
    }

    public void update(ClassroomUpdateVO vo) {
        validator.validOnUpdate(vo);
        Classroom classroom = repository.findById(vo.getId()).orElseThrow(() -> {
            throw new NotFoundException("Classroom not found");
        });
        BeanUtils.copyProperties(vo, classroom, "Id", "year", "gradeId", "section");
        repository.save(classroom);
    }

    public void delete(String id) {
        validator.validateKey(id);
        Classroom classroom = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Classroom not found");
        });
        studentService.deleteClassroomId(classroom.getId());
        repository.delete(classroom);
    }

    public void deleteUserId(String userId) {
        validator.validateKey(userId);
        List<Classroom> list = repository.findAllByTeacherIdEquals(userId);
        if (list.isEmpty()) {
            throw new NotFoundException("Classroom not found");
        } else {
            repository.deleteAll(list);
        }
    }

    public void deleteGradeId(String id) {
        validator.validateKey(id);
        List<Classroom> list = repository.findAllByGradeIdEquals(id);
        if (list.isEmpty()) {
            throw new NotFoundException("Classroom not found");
        }
        repository.deleteAll(list);
    }

    public ClassroomGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("classroom not found");
        }));
    }

    public ClassroomDetailVO detail(String id) {
        validator.validateKey(id);
        Classroom classroom = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("classroom not found");
        });
        TeacherGetVO teacherGetVO = client.get(classroom.getTeacherId()).getData();
        ClassroomDetailVO detailVO = mapper.fromDetailVO(classroom);
        detailVO.setTeacher(teacherGetVO);
        return detailVO;
    }

    public List<ClassroomGetVO> list(ClassroomCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }

    public List<ClassroomDetailVO> listGetDetail(ClassroomCriteria criteria) {
        List<ClassroomDetailVO> detailVOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        Page<Classroom> all = repository.findAll(request);
        for (Classroom classroom : all) {
            detailVOS.add(detail(classroom.getId()));
        }
        return detailVOS;
    }

    public List<ClassroomGetVO> listKeyValue(String key, String value) {
        validator.validateKeyValue(key, value);
        if (BaseUtils.hasField(Classroom.class, key)) {
            if (BaseUtils.fieldGetType(Classroom.class, key, "String")) {
                return mapper.fromGetListVO(repository.findAll(key, value));
            } else {
                return mapper.fromGetListVO(repository.findAll(key, Integer.valueOf(value)));
            }
        } else {
            throw new RuntimeException("Field not found");
        }
    }

    public List<ClassroomGetVO> listKeyValue(String key, Integer minValue, Integer maxValue) {
        validator.validateKeyMinMax(key, minValue, maxValue);
        if (BaseUtils.hasField(Classroom.class, key)) {
            if (BaseUtils.fieldGetType(Classroom.class, key, "int")) {
                if (checkMinMaxValue(minValue, maxValue)) {
                    return mapper.fromGetListVO(repository.findAll(key, (minValue - 1), (maxValue + 1)));
                } else {
                    throw new RuntimeException("min value is not little max value");
                }
            } else {
                throw new RuntimeException("Class field is not Numeric type");
            }
        } else {
            throw new RuntimeException("Not found Class Field");
        }
    }

    public Long count() {
        return repository.count();
    }

    private boolean checkMinMaxValue(Integer min, Integer max) {
        if (max == 0 || (min.equals(max))) {
            throw new RuntimeException("Invalid value");
        }
        return min < max;
    }
}

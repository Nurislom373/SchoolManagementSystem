package org.khasanof.classroomservice.service.classroom;

import org.khasanof.classroomservice.criteria.classroom.ClassroomCriteria;
import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.mapper.classroom.ClassroomMapper;
import org.khasanof.classroomservice.repository.classroom.ClassroomRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.utils.BaseUtils;
import org.khasanof.classroomservice.validator.classroom.ClassroomValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomDetailVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.khasanof.classroomservice.vo.teacher.TeacherGetVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ClassroomService extends AbstractService<ClassroomRepository, ClassroomMapper, ClassroomValidator> {

    private final ClassroomServiceClient client;

    public ClassroomService(ClassroomRepository repository, ClassroomMapper mapper, ClassroomValidator validator, ClassroomServiceClient client) {
        super(repository, mapper, validator);
        this.client = client;
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
        repository.delete(classroom);
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

    public List<ClassroomGetVO> listKeyValue(String key, String value) {
        validator.validateKeyValue(key, value);
        if (BaseUtils.hasField(Classroom.class, key)) {
            if (BaseUtils.fieldGetType(Classroom.class, key).getSimpleName().equalsIgnoreCase("String")) {
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
        return mapper.fromGetListVO(repository.findAll(key, (minValue - 1), (maxValue + 1)));
    }

    public Long count() {
        return repository.count();
    }
}

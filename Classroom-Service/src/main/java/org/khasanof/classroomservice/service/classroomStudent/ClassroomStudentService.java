package org.khasanof.classroomservice.service.classroomStudent;

import org.khasanof.classroomservice.criteria.classroomStudent.ClassroomStudentCriteria;
import org.khasanof.classroomservice.domain.classroomStudent.ClassroomStudent;
import org.khasanof.classroomservice.mapper.classroomStudent.ClassroomStudentMapper;
import org.khasanof.classroomservice.repository.classroomStudent.ClassroomStudentRepository;
import org.khasanof.classroomservice.response.Data;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.service.classroom.ClassroomService;
import org.khasanof.classroomservice.validator.classroomStudent.ClassroomStudentValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentCreateVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentDetailVO;
import org.khasanof.classroomservice.vo.classroomStudent.ClassroomStudentGetVO;
import org.khasanof.classroomservice.vo.student.StudentGetVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
public class ClassroomStudentService extends AbstractService<ClassroomStudentRepository, ClassroomStudentMapper, ClassroomStudentValidator> {

    private final ClassroomStudentServiceClient client;
    private final ClassroomService classroomService;

    public ClassroomStudentService(ClassroomStudentRepository repository, ClassroomStudentMapper mapper, ClassroomStudentValidator validator, ClassroomStudentServiceClient client, ClassroomService classroomService) {
        super(repository, mapper, validator);
        this.client = client;
        this.classroomService = classroomService;
    }

    public void create(ClassroomStudentCreateVO vo) {
        validator.validOnCreate(vo);
        if (Objects.isNull(repository.findByClassroomIdAndStudentIdEquals(vo.getClassroomId(), vo.getStudentId()))) {
            repository.save(mapper.toCreateVO(vo));
        } else {
            throw new RuntimeException("Classroom Student is already created!");
        }
    }

    public void delete(String id) {
        validator.validateKey(id);
        ClassroomStudent classroomStudent = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Classroom Student not found");
        });
        repository.delete(classroomStudent);
    }

    public ClassroomStudentGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("classroom student not found");
        }));
    }

    public ClassroomStudentDetailVO detail(String id) {
        validator.validateKey(id);
        ClassroomStudent classroomStudent = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Classroom student not found");
        });
        Data<StudentGetVO> studentGetVOData = client.get(classroomStudent.getStudentId());
        ClassroomGetVO classroomGetVO = classroomService.get(classroomStudent.getClassroomId());
        ClassroomStudentDetailVO detailVO = ClassroomStudentDetailVO.builder()
                .classroom(Objects.isNull(classroomGetVO) ? null : classroomGetVO)
                .student(Objects.isNull(studentGetVOData.getData()) ? null : studentGetVOData.getData())
                .build();
        detailVO.setId(classroomStudent.getId());
        return detailVO;
    }

    public List<ClassroomStudentGetVO> list(ClassroomStudentCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }

    public List<ClassroomStudentGetVO> list(String id) {
        ClassroomGetVO classroomGetVO = classroomService.get(id);
        if (Objects.isNull(classroomGetVO)) {
            throw new NotFoundException("Classroom not found");
        }
        return mapper.fromGetListVO(repository.findAllByClassroomIdEquals(id));
    }

    public Long count() {
        return repository.count();
    }

    public void deleteUserId(String id) {
        validator.validateKey(id);
        List<ClassroomStudent> list = repository.findAllByStudentIdEquals(id);
        if (list.isEmpty()) {
            throw new NotFoundException("Classroom Student not found");
        } else {
            repository.deleteAll(list);
        }
    }

    public void deleteClassroomId(String id) {
        validator.validateKey(id);
        List<ClassroomStudent> list = repository.findAllByClassroomIdEquals(id);
        if (list.isEmpty()) {
            throw new NotFoundException("Classroom Student not found");
        }
        repository.deleteAll(list);
    }
}

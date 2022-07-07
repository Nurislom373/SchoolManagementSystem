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

@Service
public class ClassroomStudentService extends AbstractService<ClassroomStudentRepository, ClassroomStudentMapper, ClassroomStudentValidator> {

    private final ClassroomStudentServiceClient client;
    private final ClassroomService classroomService;
    Logger logger = LoggerFactory.getLogger(ClassroomStudentService.class);

    public ClassroomStudentService(ClassroomStudentRepository repository, ClassroomStudentMapper mapper, ClassroomStudentValidator validator, ClassroomStudentServiceClient client, ClassroomService classroomService) {
        super(repository, mapper, validator);
        this.client = client;
        this.classroomService = classroomService;
    }

    public void create(ClassroomStudentCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
        logger.info("successfully created classroomStudent with - " + Thread.currentThread().getName());
    }

    public void delete(String id) {
        validator.validateKey(id);
        ClassroomStudent classroomStudent = repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom student not found to delete method with - " + Thread.currentThread().getName());
            throw new NotFoundException("Classroom Student not found");
        });
        repository.delete(classroomStudent);
        logger.info("successfully delete classroom student with - " + Thread.currentThread().getName());
    }

    public ClassroomStudentGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom student not found to get method with - " + Thread.currentThread().getName());
            throw new NotFoundException("classroom student not found");
        }));
    }

    public ClassroomStudentDetailVO detail(String id) {
        validator.validateKey(id);
        ClassroomStudent classroomStudent = repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom student not found to detail method with - " + Thread.currentThread().getName());
            throw new NotFoundException("Classroom student not found");
        });
        Data<StudentGetVO> studentGetVOData = client.get(classroomStudent.getStudentId());
        ClassroomGetVO classroomGetVO = classroomService.get(classroomStudent.getClassroomId());
        ClassroomStudentDetailVO detailVO = new ClassroomStudentDetailVO(studentGetVOData.getData(), classroomGetVO);
        detailVO.setId(classroomStudent.getId());
        return detailVO;
    }

    public List<ClassroomStudentGetVO> list(ClassroomStudentCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        logger.info("successfully list classroom student with - " + Thread.currentThread().getName());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }
}

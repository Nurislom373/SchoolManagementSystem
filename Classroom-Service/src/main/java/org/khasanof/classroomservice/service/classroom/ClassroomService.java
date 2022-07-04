package org.khasanof.classroomservice.service.classroom;

import org.khasanof.classroomservice.criteria.classroom.ClassroomCriteria;
import org.khasanof.classroomservice.domain.classroom.Classroom;
import org.khasanof.classroomservice.mapper.classroom.ClassroomMapper;
import org.khasanof.classroomservice.repository.classroom.ClassroomRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.validator.classroom.ClassroomValidator;
import org.khasanof.classroomservice.vo.classroom.ClassroomCreateVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomDetailVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomUpdateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ClassroomService extends AbstractService<ClassroomRepository, ClassroomMapper, ClassroomValidator> {

    Logger logger = LoggerFactory.getLogger(ClassroomService.class);

    public ClassroomService(ClassroomRepository repository, ClassroomMapper mapper, ClassroomValidator validator) {
        super(repository, mapper, validator);
    }

    public void create(ClassroomCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
        logger.info("successfully created classroom with - " + Thread.currentThread().getName());
    }

    public void update(ClassroomUpdateVO vo) {
        validator.validOnUpdate(vo);
        Classroom classroom = repository.findById(vo.getId()).orElseThrow(() -> {
            logger.warn("warning classroom not found to update method classroom with - " + Thread.currentThread().getName());
            return new NotFoundException("Classroom not found");
        });
        BeanUtils.copyProperties(vo, classroom, "Id", "year", "gradeId", "section");
        repository.save(classroom);
        logger.info("successfully updated classroom with - " + Thread.currentThread().getName());
    }

    public void delete(String id) {
        validator.validateKey(id);
        Classroom classroom = repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom not found to delete method classroom with - " + Thread.currentThread().getName());
            return new NotFoundException("Classroom not found");
        });
        repository.delete(classroom);
        logger.info("successfully deleted classroom with - " + Thread.currentThread().getName());
    }

    public ClassroomGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom not found to get method classroom with - " + Thread.currentThread().getName());
            return new NotFoundException("classroom not found");
        }));
    }

    public ClassroomDetailVO detail(String id) {
        validator.validateKey(id);
        return mapper.fromDetailVO(repository.findById(id).orElseThrow(() -> {
            logger.warn("warning classroom not found to detail method classroom with - " + Thread.currentThread().getName());
            return new NotFoundException("classroom not found");
        }));
    }

    public List<ClassroomGetVO> list(ClassroomCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(), criteria.getFieldsEnum().getValue());
        logger.info("successfully list classroom with - " + Thread.currentThread().getName());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }
}

package org.khasanof.classroomservice.service.grade;

import org.khasanof.classroomservice.criteria.grade.GradeCriteria;
import org.khasanof.classroomservice.domain.grade.Grade;
import org.khasanof.classroomservice.mapper.grade.GradeMapper;
import org.khasanof.classroomservice.repository.grade.GradeRepository;
import org.khasanof.classroomservice.service.AbstractService;
import org.khasanof.classroomservice.validator.grade.GradeValidator;
import org.khasanof.classroomservice.vo.grade.GradeCreateVO;
import org.khasanof.classroomservice.vo.grade.GradeGetVO;
import org.khasanof.classroomservice.vo.grade.GradeUpdateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class GradeService extends AbstractService<GradeRepository, GradeMapper, GradeValidator> {

    Logger logger = LoggerFactory.getLogger(GradeService.class);

    public GradeService(GradeRepository repository, GradeMapper mapper, GradeValidator validator) {
        super(repository, mapper, validator);
    }

    public void create(GradeCreateVO vo) {
        validator.validOnCreate(vo);
        repository.save(mapper.toCreateVO(vo));
        logger.info("successfully created Grade with - " + Thread.currentThread().getName());
    }

    public void update(GradeUpdateVO vo) {
        validator.validOnUpdate(vo);
        Grade grade = repository.findById(vo.getId()).orElseThrow(() -> {
            logger.error("Grade not found with - " + Thread.currentThread().getName());
            throw new NotFoundException("Grade not found");
        });
        BeanUtils.copyProperties(vo, grade, "id");
        repository.save(grade);
        logger.info("successfully updated Grade with - " + Thread.currentThread().getName());
    }

    public void delete(String id) {
        validator.validateKey(id);
        Grade grade = repository.findById(id).orElseThrow(() -> {
            logger.error("Grade not found with - " + Thread.currentThread().getName());
            throw new NotFoundException("Grade not found");
        });
        repository.delete(grade);
        logger.info("successfully deleted Grade with - " + Thread.currentThread().getName());
    }

    public GradeGetVO get(String id) {
        validator.validateKey(id);
        return mapper.fromGetVO(repository.findById(id).orElseThrow(() -> {
            logger.error("Grade not found with - " + Thread.currentThread().getName());
            throw new NotFoundException("Grade not found");
        }));
    }

    public List<GradeGetVO> list(GradeCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        logger.info("successfully list Grade with - " + Thread.currentThread().getName());
        return mapper.fromGetListVO(repository.findAll(request).stream().toList());
    }
}

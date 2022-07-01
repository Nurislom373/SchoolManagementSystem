package org.khasanof.examservice.examType;

import org.khasanof.examservice.examType.dto.ExamTypeCreateDTO;
import org.khasanof.examservice.examType.dto.ExamTypeGetDTO;
import org.khasanof.examservice.examType.dto.ExamTypeUpdateDTO;
import org.khasanof.examservice.examType.entity.ExamType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ExamTypeMapper {
    ExamType toCreateDTO(ExamTypeCreateDTO DTO);

    ExamTypeCreateDTO fromCreateDTO(ExamType entity);

    ExamType toUpdateDTO(ExamTypeUpdateDTO DTO);

    ExamTypeUpdateDTO fromUpdateDTO(ExamType entity);

    ExamType toGetDTO(ExamTypeGetDTO DTO);

    ExamTypeGetDTO fromGetDTO(ExamType entity);

}

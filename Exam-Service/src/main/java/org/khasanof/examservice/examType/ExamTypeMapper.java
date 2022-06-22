package org.khasanof.examservice.examType;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ExamTypeMapper {
    ExamType toCreateDTO(ExamTypeCreateDTO DTO);

    ExamTypeCreateDTO fromCreateDTO(ExamType entity);
}

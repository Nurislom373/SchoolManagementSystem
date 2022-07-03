package org.khasanof.examservice.examResult;

import org.khasanof.examservice.examResult.dto.ExamResultCreateDTO;
import org.khasanof.examservice.examResult.dto.ExamResultDetailDTO;
import org.khasanof.examservice.examResult.dto.ExamResultGetDTO;
import org.khasanof.examservice.examResult.dto.ExamResultUpdateDTO;
import org.khasanof.examservice.examResult.entity.ExamResult;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ExamResultMapper {
    ExamResult toCreateDTO(ExamResultCreateDTO DTO);

    ExamResultCreateDTO fromCreateDTO(ExamResult entity);

    ExamResult toUpdateDTO(ExamResultUpdateDTO DTO);

    ExamResultUpdateDTO fromUpdateDTO(ExamResult entity);

    ExamResult toGetDTO(ExamResultGetDTO DTO);

    ExamResultGetDTO fromGetDTO(ExamResult entity);

    ExamResult toDetailDTO(ExamResultDetailDTO DTO);

    ExamResultDetailDTO fromDetailDTO(ExamResult entity);
}

package org.khasanof.examservice.exam;

import org.khasanof.examservice.exam.dto.ExamCreateDTO;
import org.khasanof.examservice.exam.dto.ExamGetDTO;
import org.khasanof.examservice.exam.dto.ExamUpdateDTO;
import org.khasanof.examservice.exam.entity.Exam;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toCreateDTO(ExamCreateDTO DTO);

    ExamCreateDTO fromCreateDTO(Exam entity);

    Exam toUpdateDTO(ExamUpdateDTO DTO);

    ExamUpdateDTO fromUpdateDTO(Exam entity);

    Exam toGetDTO(ExamGetDTO DTO);

    ExamGetDTO fromGetDTO(Exam entity);
}

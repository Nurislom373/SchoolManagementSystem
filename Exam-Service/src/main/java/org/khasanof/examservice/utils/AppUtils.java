package org.khasanof.examservice.utils;

import org.khasanof.examservice.examType.ExamType;
import org.khasanof.examservice.examType.dto.ExamTypeCreateDTO;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ExamTypeCreateDTO entityToDTO(ExamType examType) {
        ExamTypeCreateDTO dto = new ExamTypeCreateDTO();
        BeanUtils.copyProperties(examType, dto);
        return dto;
    }

    public static ExamType dtoToEntity(ExamTypeCreateDTO dto) {
        ExamType product = new ExamType();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}

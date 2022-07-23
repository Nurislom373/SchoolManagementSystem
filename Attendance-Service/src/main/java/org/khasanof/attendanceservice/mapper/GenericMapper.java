package org.khasanof.attendanceservice.mapper;

import org.khasanof.attendanceservice.dto.BaseDTO;
import org.khasanof.attendanceservice.dto.GenericDTO;
import org.khasanof.attendanceservice.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, DD extends GenericDTO, E extends BaseEntity> {
    E toCreateDTO(CD DTO);

    CD fromCreateDTO(E entity);

    E toUpdateDTO(UD DTO);

    UD fromUpdateDTO(E entity);

    E toGetDTO(GD DTO);

    GD fromGetDTO(E entity);

    List<E> toGetListDTO(List<GD> DTO);

    List<GD> fromGetListDTO(List<E> entity);

    E toDetailDTO(DD DTO);

    DD fromDetailDTO(E entity);
}

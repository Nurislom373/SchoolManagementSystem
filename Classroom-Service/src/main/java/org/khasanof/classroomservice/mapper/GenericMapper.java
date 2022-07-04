package org.khasanof.classroomservice.mapper;


import org.khasanof.classroomservice.domain.BaseEntity;
import org.khasanof.classroomservice.vo.BaseVO;
import org.khasanof.classroomservice.vo.GenericVO;

import java.util.List;

public interface GenericMapper<CD extends BaseVO, UD extends GenericVO, GD extends GenericVO, DD extends GenericVO, E extends BaseEntity> extends BaseMapper {
    E toCreateVO(CD VO);

    CD fromCreateVO(E entity);

    E toUpdateVO(UD VO);

    UD fromUpdateVO(E entity);

    E toGetVO(GD VO);

    GD fromGetVO(E entity);

    List<E> toGetListVO(List<GD> VO);

    List<GD> fromGetListVO(List<E> entity);

    E toDetailVO(DD VO);

    DD fromDetailVO(E entity);
}

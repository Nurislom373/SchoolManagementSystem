package org.khasanof.classroomservice.service;

import lombok.RequiredArgsConstructor;
import org.khasanof.classroomservice.mapper.BaseMapper;
import org.khasanof.classroomservice.repository.BaseRepository;
import org.khasanof.classroomservice.validator.BaseValidator;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository, M extends BaseMapper, V extends BaseValidator> implements BaseService {
    protected final R repository;
    protected final M mapper;
    protected final V validator;
}

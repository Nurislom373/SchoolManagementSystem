package org.khasanof.authservice.service;

import lombok.RequiredArgsConstructor;
import org.khasanof.authservice.mapper.BaseMapper;
import org.khasanof.authservice.repository.BaseRepository;
import org.khasanof.authservice.validator.BaseValidator;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository, M extends BaseMapper, V extends BaseValidator> implements BaseService{
    protected final R repository;
    protected final M mapper;
    protected final V validator;
}

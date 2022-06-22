package org.khasanof.authservice.service.parent;

import org.khasanof.authservice.mapper.parent.ParentMapper;
import org.khasanof.authservice.repository.parent.ParentRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.validator.parent.ParentValidator;
import org.springframework.stereotype.Service;

@Service
public class ParentService extends AbstractService<ParentRepository, ParentMapper, ParentValidator> {
    public ParentService(ParentRepository repository, ParentMapper mapper, ParentValidator validator) {
        super(repository, mapper, validator);
    }
}

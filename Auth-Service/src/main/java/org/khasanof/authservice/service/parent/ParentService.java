package org.khasanof.authservice.service.parent;

import org.khasanof.authservice.config.encryptions.PasswordEncoderConfigurer;
import org.khasanof.authservice.criteria.parent.ParentCriteria;
import org.khasanof.authservice.dto.parent.ParentCreateDTO;
import org.khasanof.authservice.dto.parent.ParentDetailDTO;
import org.khasanof.authservice.dto.parent.ParentGetDTO;
import org.khasanof.authservice.dto.parent.ParentUpdateDTO;
import org.khasanof.authservice.entity.parent.Parent;
import org.khasanof.authservice.mapper.parent.ParentMapper;
import org.khasanof.authservice.repository.parent.ParentRepository;
import org.khasanof.authservice.service.AbstractService;
import org.khasanof.authservice.validator.parent.ParentValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ParentService extends AbstractService<ParentRepository, ParentMapper, ParentValidator> {

    public ParentService(ParentRepository repository, ParentMapper mapper, ParentValidator validator) {
        super(repository, mapper, validator);
    }

    Logger logger = LoggerFactory.getLogger(ParentService.class);

    @Async
    public void create(ParentCreateDTO dto) {
        validator.validOnCreate(dto);
        dto.setPassword(new PasswordEncoderConfigurer().passwordEncoder().encode(dto.getPassword()));
        logger.info("create parent with -> " + Thread.currentThread().getName());
        repository.save(mapper.toCreateDTO(dto));
    }

    @Async
    public void update(ParentUpdateDTO dto) {
        validator.validOnUpdate(dto);
        logger.info("update parent with -> " + Thread.currentThread().getName());
        Optional<Parent> optional = repository.findById(dto.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException("Parent not found");
        }
        Parent parent = optional.get();
        BeanUtils.copyProperties(dto, parent, "id", "dateOfJoin", "password");
        repository.save(parent);
    }

    @Async
    public void delete(String id) {
        validator.validateKey(id);
        logger.info("delete parent with -> " + Thread.currentThread().getName());
        Optional<Parent> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Parent not found");
        }
        repository.deleteById(id);
    }

    @Async
    public CompletableFuture<ParentGetDTO> get(String id) {
        validator.validateKey(id);
        logger.info("get parent with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromGetDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Parent not found"))));
    }

    @Async
    public CompletableFuture<ParentDetailDTO> detail(String id) {
        validator.validateKey(id);
        logger.info("detail parent with -> " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(mapper.fromDetailDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Parent not found"))));
    }

    @Async
    public CompletableFuture<List<ParentGetDTO>> list(ParentCriteria criteria) {
        logger.info("list parent with -> " + Thread.currentThread().getName());
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        return CompletableFuture.completedFuture(mapper.fromGetListDTO(repository.findAll(request).toList()));
    }
}

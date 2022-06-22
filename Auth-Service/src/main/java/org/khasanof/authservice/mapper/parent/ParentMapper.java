package org.khasanof.authservice.mapper.parent;

import org.khasanof.authservice.dto.parent.ParentCreateDTO;
import org.khasanof.authservice.dto.parent.ParentDetailDTO;
import org.khasanof.authservice.dto.parent.ParentGetDTO;
import org.khasanof.authservice.dto.parent.ParentUpdateDTO;
import org.khasanof.authservice.entity.parent.Parent;
import org.khasanof.authservice.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ParentMapper extends GenericMapper<ParentCreateDTO, ParentUpdateDTO, ParentGetDTO, ParentDetailDTO, Parent> {
}

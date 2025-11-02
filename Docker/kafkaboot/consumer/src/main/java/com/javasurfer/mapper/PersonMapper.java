package com.javasurfer.mapper;

import com.javasurfer.dto.Person;
import com.javasurfer.entities.PersonEntity;
import com.javasurfer.entities.collections.PersonDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "address", source = "dto.address")
    PersonEntity toEntity(Person dto);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "phone", source = "entity.phone")
    @Mapping(target = "address", source = "entity.address")
    Person toDto(PersonEntity entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "address", source = "dto.address")
    PersonDocument toDocument(Person dto);

    @Mapping(target = "id", source = "document.id")
    @Mapping(target = "name", source = "document.name")
    @Mapping(target = "email", source = "document.email")
    @Mapping(target = "phone", source = "document.phone")
    @Mapping(target = "address", source = "document.address")
    Person toDto(PersonDocument document);
}

package com.javasurfer.mapper;

import com.javasurfer.dto.Person;
import com.javasurfer.entities.PersonEntity;
import com.javasurfer.entities.collections.PersonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonMapperIm {

    @Autowired
    private PersonMapper personMapper;

    public PersonEntity convertToEntity(Person dto) {
        return personMapper.toEntity(dto);
    }

    public Person convertToDto(PersonEntity entity) {
        return personMapper.toDto(entity);
    }

    public PersonDocument convertToDocument(Person dto) {
        return personMapper.toDocument(dto);
    }

    public Person convertToDto(PersonDocument document) {
        return personMapper.toDto(document);
    }
}

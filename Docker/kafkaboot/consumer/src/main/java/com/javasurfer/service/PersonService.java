package com.javasurfer.service;

import com.javasurfer.dto.Person;
import com.javasurfer.mapper.PersonMapperIm;
import com.javasurfer.repositories.PersonRepo;
import com.javasurfer.repositories.mongo.PersonMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonMapperIm personMapperImpl;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PersonMongo personMongo;

    public void savePersonEntity(Person person) {
        var personEntity = personMapperImpl.convertToEntity(person);
        personRepo.save(personEntity);
    }

    public void savePerson(Person person) {
        var personDocument = personMapperImpl.convertToDocument(person);
        personMongo.save(personDocument);
    }

}

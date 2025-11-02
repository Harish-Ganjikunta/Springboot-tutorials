package com.javasurfer.repositories.mongo;

import com.javasurfer.entities.collections.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongo  extends MongoRepository<PersonDocument, Integer> {
}

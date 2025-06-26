package com.hari.cloud.repository;

import com.hari.cloud.dto.Photos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends MongoRepository<Photos,Long> {
}

package com.hari.cloud.repository;

import com.hari.cloud.dto.Photos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotosRepository extends MongoRepository<Photos,Long> {

    List<Photos> findByAlbumId(Long albumId);

    @Query("{ 'id' : ?0 }")
    Optional<Photos> findByPhotoId(Long id);
}

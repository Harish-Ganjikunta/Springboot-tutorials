package com.hari.cloud.repository;

import com.hari.cloud.dto.MobilesDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineMobilesRepository  extends MongoRepository<MobilesDto,Long> {
}

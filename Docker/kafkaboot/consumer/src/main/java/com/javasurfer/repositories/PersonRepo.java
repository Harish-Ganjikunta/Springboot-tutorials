package com.javasurfer.repositories;

import com.javasurfer.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Integer> {
}

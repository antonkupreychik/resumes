package com.kupreychik.resumes.repository;

import com.kupreychik.resumes.model.Level;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends MongoRepository<Level, String> {
}

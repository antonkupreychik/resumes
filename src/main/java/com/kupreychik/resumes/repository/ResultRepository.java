package com.kupreychik.resumes.repository;

import com.kupreychik.resumes.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ResultRepository extends MongoRepository<Result, String> {
}

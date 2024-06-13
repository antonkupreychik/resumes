package com.kupreychik.resumes.repository;

import com.kupreychik.resumes.model.Block;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends MongoRepository<Block, ObjectId> {
}
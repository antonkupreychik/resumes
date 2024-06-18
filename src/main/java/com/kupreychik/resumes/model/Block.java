package com.kupreychik.resumes.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Document(collection = "interviewQuestionsBlocks")
@Data
public class Block {

    @Id
    private ObjectId blockId;
    private String departament;
    private String blockName;
    private int blockWeight;
    private int theoryCoefficient;
    private int practiceCoefficient;
    private LocalDateTime timeLimit;
    private int numberOfEasy;
    private int numberOfMedium;
    private int numberOfHard;
    private List<Question> questions;


}

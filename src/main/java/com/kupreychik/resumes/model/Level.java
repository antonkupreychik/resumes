package com.kupreychik.resumes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "InterviewLevel")
public class Level {
    @Id
    private String id;
    private int levelId;
    private String grade;
    private int minScore;
    private int maxScore;
}

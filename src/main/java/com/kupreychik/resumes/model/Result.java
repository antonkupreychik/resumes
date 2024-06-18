package com.kupreychik.resumes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "InterviewResult")
public class Result {
    @Id
    private String id;
    private int resultId;
    private int score;
    private int theoryScore;
    private int practiceScore;
    private boolean outcome;
    private String comment;
    private Level resultLevel;
    private ResultExpectation resultExpectation;
    private User user;
    private List<Interviewer> interviewers;
    private List<QuestionInResult> questions;
}

/**
 *
 */
@Data
class ResultExpectation {
    private boolean meetsExpectations;
    private String comment;
}

/**
 *
 */
@Data
class User {
    private int userId;
    private String fullName;
    private UserLevel level;
}

/**
 *
 */
@Data
class UserLevel {
    private int levelId;
    private String grade;
    private int minScore;
    private int maxScore;
}

/**
 *
 */
@Data
class Interviewer {
    private int interviewerId;
    private String fullName;
    private String position;
}



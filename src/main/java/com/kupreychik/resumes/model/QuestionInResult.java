package com.kupreychik.resumes.model;

import lombok.Data;

/**
 *
 */
@Data
public class QuestionInResult {
    private int questionId;
    private int answer;
    private int blockId;
    private String questionText;
    private int score;
    private String difficulty;
    private boolean isTheory;
    private String comment;
}
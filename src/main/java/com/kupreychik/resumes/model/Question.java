package com.kupreychik.resumes.model;

import lombok.Data;

@Data
public class Question {
    private int questionId;
    private String questionText;
    private String difficulty;
    private boolean isTheory;
}
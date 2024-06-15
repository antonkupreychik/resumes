package com.kupreychik.resumes.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuestionsInfo {
    private String blockName;
    private int numberOfEasy;
    private int numberOfMedium;
    private int numberOfHard;
    private List<Question> questions;
}

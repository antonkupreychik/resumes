package com.kupreychik.resumes.controller.rest;

import com.kupreychik.resumes.model.QuestionsInfo;
import com.kupreychik.resumes.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionsInfo> getAllQuestions(@RequestParam(required = false, defaultValue = "true") Boolean includePractice,
                                               @RequestParam(required = false, defaultValue = "true") Boolean includeTheory) {
        return questionService.getAllQuestions(includePractice, includeTheory);
    }
}

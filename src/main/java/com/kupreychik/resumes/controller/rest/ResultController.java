package com.kupreychik.resumes.controller.rest;

import com.kupreychik.resumes.model.QuestionInResult;
import com.kupreychik.resumes.model.Result;
import com.kupreychik.resumes.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @GetMapping
    public ResponseEntity<List<Result>> getResults() {
        return ResponseEntity.ok(resultService.getAllResults());
    }

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        return ResponseEntity.ok(resultService.createResult(result));
    }

    @PutMapping("/{resultId}/questions")
    public ResponseEntity<Result> addQuestions(@PathVariable(value = "resultId") String resultId,
                                               @RequestBody List<QuestionInResult> questionsInfos) {
        return ResponseEntity.ok(resultService.addQuestions(resultId, questionsInfos));
    }

    @PutMapping("/{resultId}/calculate")
    public ResponseEntity<Result> calculateResult(@PathVariable(value = "resultId") String resultId) {
        return ResponseEntity.ok(resultService.calculateResult(resultId));
    }
}


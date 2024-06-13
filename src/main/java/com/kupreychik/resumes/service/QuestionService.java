package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Block;
import com.kupreychik.resumes.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final BlockService blockService;

    public List<Question> getAllQuestions() {
        List<Block> interviewBlocks = blockService.findAll();

        return interviewBlocks.stream()
                .flatMap(block -> block.getQuestions().stream())
                .collect(Collectors.toList());
    }
}
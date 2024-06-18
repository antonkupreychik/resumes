package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Level;
import com.kupreychik.resumes.model.QuestionInResult;
import com.kupreychik.resumes.model.Result;
import com.kupreychik.resumes.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final BlockService blockService;
    private final LevelService levelService;

    /**
     * @return
     */
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    /**
     * @param result
     * @return
     */
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    /**
     * @param resultId
     * @param questionsInfos
     * @return
     */
    public Result addQuestions(String resultId, List<QuestionInResult> questionsInfos) {
        var result = findResultById(resultId);

        var currentQuestions = result.getQuestions();
        if (currentQuestions == null) {
            currentQuestions = new ArrayList<>();
        }
        currentQuestions.addAll(questionsInfos);
        result.setQuestions(currentQuestions);

        return resultRepository.save(result);
    }

    /**
     * @param resultId
     * @return
     */
    public Result calculateResult(String resultId) {
        var result = findResultById(resultId);

        //calculating score
        calculatingResults(result);
        return resultRepository.save(result);
    }

    private void calculatingResults(Result result) {
        var allBlocks = blockService.findAll(null);
        var allLevels = levelService.getAllLevels();

        // questions[] ->
        //    blockId;
        //    score;
        //    difficulty;(level)
        //    isTheory;

        //bloks[] ->
        // blockWeight, theoryCoefficient, practiceCoefficient
        //level[] ->
        //    minScore;
        //    maxScore;

        //result.setPracticeScore();
        //result.setTheoryScore();
        //result.setScore();

        var totalScore = result.getQuestions().stream()
                .mapToDouble(QuestionInResult::getScore)
                .sum();

        var levelToSet = new Level();
        for (Level level : allLevels) {
            if (level.getMaxScore() > totalScore && totalScore > level.getMinScore()) {
                levelToSet = level;
            }
        }

        result.setScore(Integer.valueOf((int) totalScore));
        result.setResultLevel(levelToSet);
    }

    /**
     * @param resultId
     * @return
     */
    private Result findResultById(String resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new IllegalArgumentException("Result with id " + resultId + " not found"));
    }
}

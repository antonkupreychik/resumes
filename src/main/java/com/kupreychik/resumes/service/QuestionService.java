package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Block;
import com.kupreychik.resumes.model.Question;
import com.kupreychik.resumes.model.QuestionsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final BlockService blockService;

    public List<QuestionsInfo> getAllQuestions(boolean includePractice, boolean includeTheory) {
        var interviewBlocks = blockService.findAll();
        var questions = new ArrayList<QuestionsInfo>();

        interviewBlocks.forEach(interviewBlock -> {
            var question = buildQuestion(interviewBlock);
            collectQuestions(interviewBlock, question, includePractice, includeTheory);
            questions.add(question);
        });
        return questions;
    }

    private static QuestionsInfo buildQuestion(Block interviewBlock) {
        return QuestionsInfo
                .builder()
                .numberOfHard(interviewBlock.getNumberOfHard())
                .numberOfEasy(interviewBlock.getNumberOfEasy())
                .numberOfMedium(interviewBlock.getNumberOfMedium())
                .blockName(interviewBlock.getBlockName())
                .build();
    }

    private void collectQuestions(Block interviewBlock, QuestionsInfo question, boolean includePractice, boolean includeTheory) {
        List<Question> questions = interviewBlock.getQuestions();
        question.setQuestions(new ArrayList<>());

        processEasyQuestions(question, questions, includePractice, includeTheory);
        processMediumQuestions(question, questions, includePractice, includeTheory);
        processHardQuestions(question, questions, includePractice, includeTheory);
    }

    private void processHardQuestions(QuestionsInfo question, List<Question> questions, boolean includePractice, boolean includeTheory) {
        int numberOfEasy = question.getNumberOfHard();
        List<Question> easyQuestions = questions
                .stream()
                .filter(el -> filterDifficulty(el, "Hard"))
                .filter(theoryFilter(includePractice, includeTheory))
                .collect(Collectors.toList());
        Collections.shuffle(easyQuestions);

        question.getQuestions().addAll(easyQuestions.stream()
                .limit(numberOfEasy)
                .toList());
    }

    private void processMediumQuestions(QuestionsInfo question, List<Question> questions, boolean includePractice, boolean includeTheory) {
        int numberOfEasy = question.getNumberOfMedium();
        List<Question> easyQuestions = questions
                .stream()
                .filter(el -> filterDifficulty(el, "Medium"))
                .filter(theoryFilter(includePractice, includeTheory))
                .collect(Collectors.toList());
        Collections.shuffle(easyQuestions);

        question.getQuestions().addAll(easyQuestions.stream()
                .limit(numberOfEasy)
                .toList());
    }

    private void processEasyQuestions(QuestionsInfo question, List<Question> questions, boolean includePractice, boolean includeTheory) {
        int numberOfEasy = question.getNumberOfEasy();
        List<Question> easyQuestions = questions
                .stream()
                .filter(el -> filterDifficulty(el, "Easy"))
                .filter(theoryFilter(includePractice, includeTheory))
                .collect(Collectors.toList());
        Collections.shuffle(easyQuestions);

        question.getQuestions().addAll(easyQuestions.stream()
                .limit(numberOfEasy)
                .toList());
    }

    private Predicate<Question> theoryFilter(boolean includePractice, boolean includeTheory) {
        return el -> {
            var isTheory = el.isTheory();
            if (includeTheory) {
                return isTheory;
            }
            if (includePractice) {
                return !isTheory;
            }
            return true;
        };
    }

    private boolean filterDifficulty(Question el, String difficulty) {
        return el.getDifficulty().equals(difficulty);
    }
}
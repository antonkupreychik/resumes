package com.kupreychik.resumes.controller.web;

import com.kupreychik.resumes.service.BlockService;
import com.kupreychik.resumes.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class InterviewController {

    protected static final String BLOCKS = "blocks";
    private final QuestionService questionService;
    private final BlockService blockService;

    @GetMapping("/greeting")
    public ModelAndView interviewPage(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting");
        modelAndView.addObject("navigation", blockService.findAll());
        return modelAndView;
    }

    @GetMapping("/block/{name}")
    public ModelAndView interviewBlock(@PathVariable String name, ModelAndView modelAndView) {
        modelAndView.addObject(BLOCKS, questionService.getAllQuestions(true, false));
        modelAndView.setViewName(name);
        return modelAndView;
    }

    @GetMapping("/theoretical-part")
    public ModelAndView theoreticalPart(ModelAndView modelAndView) {
        modelAndView.setViewName("theoretical-part");
        modelAndView.addObject(BLOCKS, questionService.getAllQuestions(false, true));
        return modelAndView;
    }

    @GetMapping("/practical-part")
    public ModelAndView practicalPart(ModelAndView modelAndView) {
        modelAndView.setViewName("practical-part");
        modelAndView.addObject(BLOCKS, questionService.getAllQuestions(true, false));
        return modelAndView;
    }
}
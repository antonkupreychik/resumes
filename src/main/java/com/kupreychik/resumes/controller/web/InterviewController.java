package com.kupreychik.resumes.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InterviewController {

    @GetMapping("/interview")
    public String interviewPage(Model model) {
        // Передайте необходимые данные в модель, если нужно
        return "interview";
    }

    @GetMapping("/interview/next/{id}")
    public String nextPage(Model model, @PathVariable Long id) {
        return "next";
    }
}
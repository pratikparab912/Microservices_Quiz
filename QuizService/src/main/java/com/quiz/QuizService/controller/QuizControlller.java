package com.quiz.QuizService.controller;

import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizControlller {
    private QuizService quizService;

    public QuizControlller(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz add(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    @GetMapping("/{Id}")
    public Quiz getById(@PathVariable Long Id) {
        return quizService.getById(Id);
    }
}

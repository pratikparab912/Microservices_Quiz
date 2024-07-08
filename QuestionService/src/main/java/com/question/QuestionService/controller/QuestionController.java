package com.question.QuestionService.controller;

import com.question.QuestionService.entity.Question;
import com.question.QuestionService.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question add(@RequestBody Question question) {
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> getAllQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId) {
        return questionService.getByQuestionId(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getAllQuestionByQuizId(@PathVariable Long quizId) {
        return questionService.getAllQuestionByQuizId(quizId);
    }
}

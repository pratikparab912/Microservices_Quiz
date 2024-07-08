package com.quiz.QuizService.service;

import com.quiz.QuizService.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> getAll();
    Quiz getById(Long Id);
}

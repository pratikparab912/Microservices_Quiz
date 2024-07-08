package com.quiz.QuizService.service.impl;

import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import com.quiz.QuizService.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz getById(Long Id) {
        Quiz quiz = quizRepository.findById(Id).orElseThrow(()->new RuntimeException("Quiz Id not found"));
        quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}

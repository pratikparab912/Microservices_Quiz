package com.question.QuestionService.service.impl;

import com.question.QuestionService.entity.Question;
import com.question.QuestionService.repository.QuestionRepository;
import com.question.QuestionService.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getByQuestionId(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("Question Id not found."));
    }

    @Override
    public List<Question> getAllQuestionByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}

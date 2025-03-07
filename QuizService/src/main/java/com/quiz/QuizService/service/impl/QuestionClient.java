package com.quiz.QuizService.service.impl;

import com.quiz.QuizService.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:7072",value = "Question-Service")
@FeignClient(name= "QUESTIONSERVICE")
public interface QuestionClient {
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getAllQuestionsOfQuiz(@PathVariable Long quizId);
}

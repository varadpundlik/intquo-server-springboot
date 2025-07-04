package com.example.intquo.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("/questions/topic/{topic}")
    public List<Question> getQuestionsByTopic(@PathVariable String topic){
        return questionRepository.findByTopic(topic);
    }

    @GetMapping("/questions/company/{company}")
    public List<Question> getQuestionsByCompany(@PathVariable String company){
        return questionRepository.findByCompany(company);
    }

    @GetMapping("/questions/college/{college}")
    public List<Question> getQuestionsByCollege(@PathVariable String college){
        return questionRepository.findByCollege(college);
    }
}

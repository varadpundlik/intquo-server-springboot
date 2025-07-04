package com.example.intquo.questions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCompany(String company);
    List<Question> findByCollege(String college);
    List<Question> findByTopic(String topic);
}

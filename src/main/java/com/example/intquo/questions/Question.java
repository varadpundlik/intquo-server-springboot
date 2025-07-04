package com.example.intquo.questions;

import com.example.intquo.interviews.Interview;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(nullable = false)
    private String question;

    @Lob
    @Column(nullable = false)
    private String user_answer;

    @Lob
    @Column(nullable = false)
    private String ai_answer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private String subtopic;

    @Column(nullable = false)
    private String college;

    @Column(nullable = false)
    private String company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "interview_id", nullable = false)
    @JsonBackReference
    private Interview interview;

    private enum Difficulty{
        Easy,Medium,Hard
    }

    public Question(Integer id, String question, String user_answer, String ai_answer, Difficulty difficulty, String topic, String college, String subtopic, String company, Interview interview) {
        this.id = id;
        this.question = question;
        this.user_answer = user_answer;
        this.ai_answer = ai_answer;
        this.difficulty = difficulty;
        this.topic = topic;
        this.college = college;
        this.subtopic = subtopic;
        this.company = company;
        this.interview = interview;
    }
    public Question() {}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", user_answer='" + user_answer + '\'' +
                ", ai_answer='" + ai_answer + '\'' +
                ", difficulty=" + difficulty +
                ", topic='" + topic + '\'' +
                ", subtopic='" + subtopic + '\'' +
                ", college='" + college + '\'' +
                ", company='" + company + '\'' +
                ", interview=" + interview +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public String getAi_answer() {
        return ai_answer;
    }

    public void setAi_answer(String ai_answer) {
        this.ai_answer = ai_answer;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }
}

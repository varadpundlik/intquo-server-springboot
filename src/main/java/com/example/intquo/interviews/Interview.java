package com.example.intquo.interviews;

import com.example.intquo.questions.Question;
import com.example.intquo.questions.QuestionService;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String job_role;

    @Column(nullable = false)
    private Integer compensation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date conducted_on;

    @Column(nullable = false)
    private String college;

    @Column(nullable = false)
    private String company;

    @Enumerated
    private Status status;

    @Enumerated
    private Result result;


    public enum Status{
        Oncampus,Offcampus
    }

    public enum Result{
        selected,rejected
    }

    public Interview(Integer id, String job_role, Integer compensation, Date conducted_on, String college, Status status, String company, Result result,List<Question> questions) {
        this.id = id;
        this.job_role = job_role;
        this.compensation = compensation;
        this.conducted_on = conducted_on;
        this.college = college;
        this.status = status;
        this.company = company;
        this.result = result;
        this.questions=questions;
    }

    public Interview() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public Integer getCompensation() {
        return compensation;
    }

    public void setCompensation(Integer compensation) {
        this.compensation = compensation;
    }

    public Date getConducted_on() {
        return conducted_on;
    }

    public void setConducted_on(Date conducted_on) {
        this.conducted_on = conducted_on;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @OneToMany(mappedBy = "interview", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        if (questions != null) {
            for (Question q : questions) {
                q.setCollege(this.college);
                q.setCompany(this.company);
                q.setAi_answer(new QuestionService().getAIAnswer(q.getQuestion()));
                q.setInterview(this);  // important step!
            }
        }
    }


    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", job_role='" + job_role + '\'' +
                ", compensation=" + compensation +
                ", conducted_on=" + conducted_on +
                ", college='" + college + '\'' +
                ", company='" + company + '\'' +
                ", status=" + status +
                ", result=" + result +
                ", questions=" + questions +
                '}';
    }
}

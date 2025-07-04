package com.example.intquo.interviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("/interviews")
    public List<Interview> getAllInterviews(){
        return interviewRepository.findAll();
    }

    @GetMapping("/interviews/{id}")
    public Interview getInterviewById(@PathVariable Integer id){
        return interviewRepository.findById(id).orElse(null);
    }

    @PostMapping("/interviews")
    public Interview createInterview(@RequestBody Interview interview){
        return interviewRepository.save(interview);
    }
}

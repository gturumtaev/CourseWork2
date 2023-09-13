package com.example.CourseWork2.controller;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.service.ExaminerService;
import com.example.CourseWork2.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/questions")
public class ExamController {
    ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }
    @GetMapping
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}

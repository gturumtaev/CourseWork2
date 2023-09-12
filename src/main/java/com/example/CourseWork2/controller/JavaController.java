package com.example.CourseWork2.controller;


import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String question,
                      @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam Question question) {
        return javaQuestionService.remove(question);
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}

package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}

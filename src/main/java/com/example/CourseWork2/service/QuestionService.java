package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;

import java.util.Collection;

public interface QuestionService {
    public static String add(String question, String answer) {
        return null;
    }

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();
}

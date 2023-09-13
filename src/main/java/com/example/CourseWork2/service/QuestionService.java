package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();
}

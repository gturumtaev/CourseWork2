package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.QuestionNotFoundException;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();

    public String add(String question, String answer) {

        return question + answer;
    }

    @Override
    public Question add(Question question) {

        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException("Сотрудник не удален, так как не был найден в базе");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random;

        return null;
    }
}

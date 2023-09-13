package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.QuestionAlreadyAddedException;
import com.example.CourseWork2.excrption.QuestionNotFoundException;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)){
            throw new QuestionAlreadyAddedException("Такой вопрос уже добавлен в список");
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        for (Question q:questions) {
            if (q.equals(question)){
                throw new QuestionAlreadyAddedException("Такой вопрос уже добавлен в список");
            }
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException("Вопрос не удален, так как не был найден в списке вопросов");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int max = questions.size();
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(max));
    }
}

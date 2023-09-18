package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.QuestionAlreadyAddedException;
import com.example.CourseWork2.excrption.QuestionNotFoundException;
import com.example.CourseWork2.excrption.NotEnoughQuestionsException;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже добавлен в список");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException("Вопрос не удален, так как не был найден в списке вопросов");
        }
        return question;

    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int max = questions.size();
        if (questions.size() == 0) {
           throw new NotEnoughQuestionsException("Вопросы не обнаружены, попробуйте добавить вопросы и повторить попытку");
        }
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(max));
    }
}

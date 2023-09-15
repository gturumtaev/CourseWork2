package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.QuestionAlreadyAddedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService listOfQuestions;
    @BeforeEach
    void addList() {
        listOfQuestions = new JavaQuestionService();
        listOfQuestions.add(new Question("Был дождь?", "Да"));
        listOfQuestions.add(new Question("Был снег?", "Нет"));
        listOfQuestions.add(new Question("Было солнце?", "Да"));
    }
    @Test
    void add_success() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("Был дождь?", "Да"),
                new Question("Был снег?", "Нет"),
                new Question("Было солнце?", "Да"),
                new Question("Была луна?", "Нет")
                ));
        Question expectedQuestion = new Question("Была луна?", "Нет");

        assertEquals(expectedQuestion, listOfQuestions.add("Была луна?", "Нет"));
        assertIterableEquals(expectedSet, listOfQuestions.getAll());
    }
    @Test
    void add_QuestionAlreadyAddedException() {
        String expectedMessage = "400 Такой вопрос уже добавлен в список";
        Exception exception = assertThrows(QuestionAlreadyAddedException.class,
                () -> listOfQuestions.add("Было солнце?", "Да")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_success() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("Был дождь?", "Да"),
                new Question("Был снег?", "Нет")
        ));
        Question expectedQuestion = new Question("Было солнце?", "Да");
        assertEquals(expectedQuestion, listOfQuestions.remove(new Question("Было солнце?", "Да")));
        assertIterableEquals(expectedSet, listOfQuestions.getAll());
    }

    @Test
    void getAll() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("Был дождь?", "Да"),
                new Question("Был снег?", "Нет"),
                new Question("Было солнце?", "Да")
        ));
        assertEquals(expectedSet, listOfQuestions.getAll());
    }

    @Test
    void getRandomQuestion() {
        assertTrue(listOfQuestions.getAll().contains(listOfQuestions.getRandomQuestion()));
    }
}
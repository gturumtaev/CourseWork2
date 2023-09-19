package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.NotEnoughQuestionsException;
import com.example.CourseWork2.excrption.QuestionAlreadyAddedException;
import com.example.CourseWork2.excrption.QuestionNotFoundException;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(listOfQuestions.getAll())
                .hasSize(4)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expectedSet);
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
    void remove_QuestionNotFoundException() {
        String expectedMessage = "404 Вопрос не удален, так как не был найден в списке вопросов";
        Exception exception = assertThrows(QuestionNotFoundException.class,
                () -> listOfQuestions.remove( new Question("Была луна?", "Нет"))
        );
        assertEquals(expectedMessage, exception.getMessage());
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
    void getRandomQuestion_success() {
        assertTrue(listOfQuestions.getAll().contains(listOfQuestions.getRandomQuestion()));
    }
    @Test
    void getRandomQuestion_NotEnoughQuestions() {
        JavaQuestionService listOfQuestionsEmpty = new JavaQuestionService();
        String expectedMessage = "404 Вопросы не обнаружены, попробуйте добавить вопросы и повторить попытку";
        Exception exception = assertThrows(NotEnoughQuestionsException.class,
                () -> listOfQuestionsEmpty.getAll().contains(listOfQuestionsEmpty.getRandomQuestion())
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
}
package com.example.CourseWork2.service;

import com.example.CourseWork2.entity.Question;
import com.example.CourseWork2.excrption.IncorrectAmountOfQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl listOfQuestions;
    private final Collection<Question> questions = new HashSet<>(Set.of(
            new Question("Был дождь?", "Да"),
            new Question("Был снег?", "Нет"),
            new Question("Было солнце?", "Да")
    ));
    @Test
    void getQuestions_success() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("Был дождь?", "Да"),
                new Question("Был снег?", "Нет"),
                new Question("Было солнце?", "Да"),
                new Question("Была луна?", "Нет")
        );
        assertIterableEquals(questions, listOfQuestions.getQuestions(3));
    }
    @Test
    void getQuestions_IncorrectAmountOfQuestionsException() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
                assertThrows(IncorrectAmountOfQuestionsException.class,
                        () -> listOfQuestions.getQuestions(questions.size() + 1));

    }

}
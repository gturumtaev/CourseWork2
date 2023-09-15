package com.example.CourseWork2.excrption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAddedException extends HttpStatusCodeException {
    public QuestionAlreadyAddedException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}

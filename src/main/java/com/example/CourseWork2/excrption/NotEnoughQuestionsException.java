package com.example.CourseWork2.excrption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotEnoughQuestionsException extends HttpStatusCodeException {
    public NotEnoughQuestionsException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

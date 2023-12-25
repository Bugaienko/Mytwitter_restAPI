package dev.baluapp.twitter.security.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
@date 25.12.2023
@author Sergey Bugaienko
*/
@RestControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeErrors(RuntimeException ex) {


        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}

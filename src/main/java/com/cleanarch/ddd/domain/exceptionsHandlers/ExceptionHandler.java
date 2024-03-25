package com.cleanarch.ddd.domain.exceptionsHandlers;

import com.cleanarch.ddd.domain.exceptions.RequiredException;
import com.cleanarch.ddd.domain.exceptions.ResourceNotFoundException;
import com.cleanarch.ddd.domain.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> allExceptionsHandle(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ResponseException> resourceNotFoundExceptionHandle(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RequiredException.class)
    public final ResponseEntity<ResponseException> requiredExceptionHandle(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }
}

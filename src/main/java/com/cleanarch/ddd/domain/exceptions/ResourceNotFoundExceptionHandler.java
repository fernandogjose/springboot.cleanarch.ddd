package com.cleanarch.ddd.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResourceNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> handleAllExceptions(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ResponseException> handleNotFound(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }
}

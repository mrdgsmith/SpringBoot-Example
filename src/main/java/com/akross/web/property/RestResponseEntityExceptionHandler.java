package com.akross.web.property;

import com.akross.service.property.exception.PropertyNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = {PropertyNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    private String notFoundEntity(final RuntimeException runtimeException) {
        return runtimeException.getMessage();
    }
}
package com.dago.todo_api.handlers;


import com.dago.todo_api.dtos.ErrorMessageDto;
import com.dago.todo_api.exceptions.CustomEntityNotFoundException;
import com.dago.todo_api.exceptions.UnableToProcessException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomEntityNotFoundException.class)
    public final ResponseEntity<Object> handleCustomEntityException(CustomEntityNotFoundException ex, WebRequest request) {
        ErrorMessageDto messageDto = new ErrorMessageDto(
                ex.getMessage(),
                String.format("Path is %s", request.getDescription(false)), LocalDateTime.now());

                return new ResponseEntity<>(messageDto, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(UnableToProcessException.class)
    public final ResponseEntity<Object> handleUnableToProcessException(UnableToProcessException ex, WebRequest request) {
        ErrorMessageDto messageDto = new ErrorMessageDto(
                ex.getMessage(),
                String.format("Path is %s", request.getDescription(false)), LocalDateTime.now());

        return new ResponseEntity<>(messageDto, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        String errorMessage = String.join(" || ", errorMessages);
        ErrorMessageDto messageDto = new ErrorMessageDto(errorMessage, String.format(
                "Error(s) found: %d", errorMessages.size()), LocalDateTime.now()
        );
        return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
    }
}

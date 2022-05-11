package com.voytenko.exceptions.hadler;

import com.voytenko.dto.ExceptionDto;
import com.voytenko.dto.ValidationErrorDto;
import com.voytenko.exceptions.ReviewNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    private final String ENTITY_NOT_FOUND_STATUS = "404";

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<Object> handleFavoritesItemException(ReviewNotFoundException exception) {
        return ResponseEntity.status(404)
                .body(ExceptionDto.builder().message(exception.getMessage()).error(ENTITY_NOT_FOUND_STATUS).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> errors = new ArrayList<>();

        exception.getBindingResult().getAllErrors().forEach(
                (error) -> errors.add(ValidationErrorDto.builder().field(error.getObjectName()).error(error.getDefaultMessage()).build())
        );

        return ResponseEntity.status(400)
                .body(errors);
    }
}

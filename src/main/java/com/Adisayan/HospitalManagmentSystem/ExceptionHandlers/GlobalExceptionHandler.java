package com.Adisayan.HospitalManagmentSystem.ExceptionHandlers;

import com.Adisayan.HospitalManagmentSystem.DTO.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class})
    public ResponseEntity<ApiResponse<Object>> handleConstraintViolation(Exception ex) {
        String message = "A unique constraint was violated. Please check your input.";
        String body = "";
        Throwable cause = ex.getCause();
        System.out.println(cause);
        if (cause instanceof ConstraintViolationException cve) {
            String constraintName = cve.getConstraintName();
            body = "Duplicate entry violates constraint: " + constraintName;
        }
        if (ex instanceof DataIntegrityViolationException dive && dive.getCause() instanceof org.hibernate.exception.ConstraintViolationException cve) {
            String constraintName = cve.getConstraintName();
            body = "Duplicate entry violates constraint: " + constraintName;
        }
        return new ResponseEntity<>(
                ApiResponse.error(message, body),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiResponse> handleMissingElementException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.error("No such element Found for the given parameter", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<ApiResponse<?>> handleEmptyDataAccessException(Exception ex) {
        System.out.println(ex.getCause());
        return new ResponseEntity<>(ApiResponse.error("operation unsuccesful", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
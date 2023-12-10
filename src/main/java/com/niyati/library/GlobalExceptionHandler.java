package com.niyati.library;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.niyati.library.api.dto.ErrorDTO;
import com.niyati.library.exceptions.*;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationErrors(MethodArgumentNotValidException e) {
      List<String> errorMessages = e.getBindingResult().getFieldErrors()
              .stream()
              .map(fieldError -> fieldError.getDefaultMessage())
              .collect(Collectors.toList());

      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(
          new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            errorMessages
          )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintViolationErrors(ConstraintViolationException e) {
      List<String> errorMessages = e.getConstraintViolations()
            .stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toList());

      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(
          new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            errorMessages
          )
        );
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleBookAlreadyExistsException(BookAlreadyExistsException e) {
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(
          new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            Arrays.asList(e.getMessage())
          )
        );
    }

    @ExceptionHandler(BookDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> handleBookDoesNotExistException(BookDoesNotExistException e) {
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(
          new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            Arrays.asList(e.getMessage())
          )
        );
    }
}

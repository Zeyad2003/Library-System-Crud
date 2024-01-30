package com.fawry.librarysystem.exception;

import com.fawry.librarysystem.model.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IdNotFoundHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<CustomResponse> handleIdNotFoundException(IdNotFoundException ex) {
        return CustomResponse.response(ex.getMessage(), HttpStatus.NOT_FOUND.value(), null);
    }
}

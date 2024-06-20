package com.aulaspring.course.resources.exceptions;


import com.aulaspring.course.services.exceptions.DatabaseException;
import com.aulaspring.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // intercepta as exceçoes para que haja tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // intercepta exceção desse tipo e faz o tratamento dentro do metodo
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND; // status do erro
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI()); // erro

        return ResponseEntity.status(status).body(err); // lança tratamento
    }

    @ExceptionHandler(DatabaseException.class) // intercepta exceção desse tipo e faz o tratamento dentro do metodo
    public ResponseEntity<StandardError> dataBaseException(DatabaseException e, HttpServletRequest request){
        String error = "DataBase error.";
        HttpStatus status = HttpStatus.BAD_REQUEST; // status do erro
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI()); // erro

        return ResponseEntity.status(status).body(err); // lança tratamento
    }


}

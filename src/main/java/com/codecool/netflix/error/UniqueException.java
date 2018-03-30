package com.codecool.netflix.error;

import com.codecool.netflix.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UniqueException extends ResponseEntityExceptionHandler {

    private Logger logger;

    public UniqueException(LoggerService loggerService){
        this.logger = loggerService.getLogger();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleDataIntegrityViolationException(){

        Error error = new Error("Constraint violation", "Can not crate constraint with the same atributes");
        logger.error("DataIntegrityViolationException exception occured");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> handleNullPointerException(){

        Error error = new Error("No constraint", "No such constraint");
        logger.error("NullPointerException exception occured");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Error> handleEmptyResultDataAccessException(){

        Error error = new Error("No constraint", "There is no such resource");
        logger.error("EmptyResultDataAccessException exception occured");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

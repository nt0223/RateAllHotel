package com.userService.exceptions;


import com.userService.payload.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleResourceNotFoundException(ResourceNotFoundException ex){
        ResponseError response=ResponseError.builder().message(ex.getMessage()).sucess(false).status(HttpStatus.NOT_FOUND).date(LocalDateTime.now()).build();
   return new ResponseEntity<ResponseError>(response,HttpStatus.NOT_FOUND);
    }


}

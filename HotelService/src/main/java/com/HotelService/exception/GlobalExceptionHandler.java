package com.HotelService.exception;


import com.HotelService.utility.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorMessage er= ErrorMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).sucess(false).localDateTime(LocalDateTime.now()).build();
    return new ResponseEntity<ErrorMessage>(er,HttpStatus.NOT_FOUND);
    }



}

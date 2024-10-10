package com.HotelService.utility;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {

    String message;
    HttpStatus status;
    boolean sucess;
    LocalDateTime localDateTime;
}

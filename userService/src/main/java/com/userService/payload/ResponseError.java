package com.userService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseError {

    private String message;
    private boolean sucess;
    private HttpStatus status;
    private LocalDateTime date;




}

package com.userService.entities;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Hotel {


    private String id;
    private String name;
    private String location;
    private String about;
}

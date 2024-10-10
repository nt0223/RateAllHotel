package com.HotelService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}

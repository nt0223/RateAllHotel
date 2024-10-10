package com.HotelService.controller;


import com.HotelService.entity.Hotel;
import com.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Validated
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return new ResponseEntity<List<Hotel>>(hotelService.getAllHotel(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getAllHotel(@PathVariable String id){
        return new ResponseEntity<Hotel>(hotelService.getHotel(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel( @RequestBody Hotel hotel){
        hotel.setId(UUID.randomUUID().toString());
        return new ResponseEntity<Hotel>(hotelService.createHotel(hotel),HttpStatus.CREATED);
    }




}

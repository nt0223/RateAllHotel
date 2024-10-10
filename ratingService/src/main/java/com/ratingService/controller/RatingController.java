package com.ratingService.controller;


import com.ratingService.entity.Rating;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }

    @GetMapping("getUser/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("getHotel/{id}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.allRating());
    }








}

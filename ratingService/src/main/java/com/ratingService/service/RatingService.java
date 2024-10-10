package com.ratingService.service;

import com.ratingService.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

     Rating addRating(Rating rating);

     List<Rating> allRating();

    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String Id);


}

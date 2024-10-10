package com.ratingService.service.ServiceImpl;


import com.ratingService.entity.Hotel;
import com.ratingService.entity.Rating;
import com.ratingService.repository.RatingRepository;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service(value="ratingService")
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository rating;

    @Autowired
    private RestTemplate template;
    @Override
    public Rating addRating(Rating ratings) {
        return rating.save(ratings);
    }

    @Override
    public List<Rating> allRating() {
        return rating.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating>rates=rating.findByUserId(userId);

        List<Rating>  r =rates.stream().map(rate->{
            String url ="http://HOTEL-SERVICE/hotels/get/"+rate.getHotelId();
             ResponseEntity<Hotel>hotel=template.getForEntity(url, Hotel.class);
             rate.setHotel(hotel.getBody());
            return rate;
        }).collect(Collectors.toList());
        return r;
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return rating.findByHotelId(id);
    }
}

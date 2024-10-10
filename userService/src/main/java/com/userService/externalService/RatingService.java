package com.userService.externalService;


import com.userService.entities.Rating;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="RATING-SERVICE")
@LoadBalancerClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/getUser/{userId}")
    List<Rating> getRatings(@PathVariable String userId);

    @PostMapping("/ratings/create")
    Rating addRatings( Rating rate);

    @PostMapping()
    public Rating updateRatings( Rating rate);



}

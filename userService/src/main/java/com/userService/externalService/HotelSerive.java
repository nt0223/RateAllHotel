package com.userService.externalService;


import com.userService.entities.Hotel;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("HOTEL-SERVICE")
@LoadBalancerClient(name="HOTEL-SERVICE")
public interface HotelSerive {

    @PostMapping("/hotels/add")
     Hotel addHotel(Hotel hotel);

    @DeleteMapping("/hotels/delete/{hotelId}")
     void deleteHotel(@PathVariable String hotelId);


}

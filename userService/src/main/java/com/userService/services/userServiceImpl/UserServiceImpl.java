package com.userService.services.userServiceImpl;


import com.userService.entities.Hotel;
import com.userService.entities.Rating;
import com.userService.entities.User;
import com.userService.exceptions.ResourceNotFoundException;
import com.userService.externalService.HotelSerive;
import com.userService.externalService.RatingService;
import com.userService.repository.UserRepository;
import com.userService.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {

     @Autowired
     private UserRepository userRepository;
     @Autowired
    RatingService ratingService;
     @Autowired
     HotelSerive hotelSerive;

    @Override
    public User saveUser(User user) {

        /*for(Rating rate:user.getRatings()) {
            rate.setUserId(user.getUserId());
            Hotel hotel = rate.getHotel();
            Hotel hot=hotelSerive.addHotel(hotel);
            rate.setHotelId(hot.getId());
        }


        ratingService.addRatings((Rating) user.getRatings());*/
        return userRepository.save(user);
    }

    @Autowired
    private RestTemplate restTemplate;

    private final static Logger log= Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //fetch rating of the above user


       List<Rating>ratings= ratingService.getRatings(userId);
       log.info(ratings.toString());
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given userId is not found"));
        user.setRatings(ratings);
        return user;
    }

    @Override
    public void deleteUser(String userId) {

        if(userId==null || userId.isBlank()){
            throw new ResourceNotFoundException("User with given userId is not found");
        }
        userRepository.deleteById(userId);
    }
}

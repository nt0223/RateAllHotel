package com.userService;

import com.userService.entities.Hotel;
import com.userService.entities.Rating;
import com.userService.externalService.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	RatingService ratingService;
	@Test
	void contextLoads() {

		Rating r= new Rating();
		r.setRating(9);
		Hotel h= new Hotel();
		h.setLocation("kanpur , india");
		h.setAbout("Hotel is famour for ---");
		h.setName("TajMahil");
		r.setHotel(h);
		r.setFeedback("Good Services");
		r.setUserId("2763724");
		ratingService.addRatings(r);


	}

}

package com.ratingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class RatingServiceApplication {
@Bean
@LoadBalanced
public RestTemplate restTemplate(){
	return new RestTemplate();
}
	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}

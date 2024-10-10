package com.HotelService.service;

import com.HotelService.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    public List<Hotel> getAllHotel();

    public Hotel getHotel(String id);

    public Hotel createHotel(Hotel hotel);





}

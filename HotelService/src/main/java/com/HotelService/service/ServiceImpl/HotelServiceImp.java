package com.HotelService.service.ServiceImpl;

import com.HotelService.Repository.HotelRepository;
import com.HotelService.entity.Hotel;
import com.HotelService.exception.ResourceNotFoundException;
import com.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Given user is not available"));
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }


}

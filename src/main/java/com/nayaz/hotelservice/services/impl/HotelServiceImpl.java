package com.nayaz.hotelservice.services.impl;

import com.nayaz.hotelservice.entities.Hotel;
import com.nayaz.hotelservice.exceptions.ResourceNotFoundException;
import com.nayaz.hotelservice.repositories.HotelRepository;
import com.nayaz.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found on server !! :" + hotelId));
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel updatehotel = hotelRepository.findById(hotelId).get();
        updatehotel.setName(hotel.getName());
        updatehotel.setLocation(hotel.getLocation());
        updatehotel.setAbout(hotel.getAbout());
        return hotelRepository.save(updatehotel);
    }

    @Override
    public void deleteHotel(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }


}

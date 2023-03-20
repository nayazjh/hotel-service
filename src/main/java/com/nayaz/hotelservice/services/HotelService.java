package com.nayaz.hotelservice.services;

import com.nayaz.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String hotelId);

    Hotel updateHotel(String hotelId, Hotel hotel);

    void deleteHotel(String hotelId);
}

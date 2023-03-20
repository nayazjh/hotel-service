package com.nayaz.hotelservice.controllers;

import com.nayaz.hotelservice.entities.Hotel;
import com.nayaz.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel)  {
        Hotel newHotel = hotelService.saveHotel(hotel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return  ResponseEntity.ok(hotel);
    }

    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> allHotels = hotelService.getAllHotels();
        return  ResponseEntity.ok(allHotels);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") String hotelId, @RequestBody Hotel hotel) {
        hotelService.updateHotel(hotelId,hotel);
        return new ResponseEntity<Hotel>(hotelService.getHotelById(hotelId), HttpStatus.OK);
    }

    @DeleteMapping({"/{hotelId}"})
    public ResponseEntity<Hotel> deleteUser(@PathVariable("hotelId") String hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

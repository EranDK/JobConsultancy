package com.mycompany.service;

import com.mycompany.model.Booking;
import com.mycompany.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void save(Booking booking){
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public void deleteById(int id){
        bookingRepository.deleteById(id);
    }

    public Booking getBookingById(int id){
        return bookingRepository.findById(id).get();
    }
}



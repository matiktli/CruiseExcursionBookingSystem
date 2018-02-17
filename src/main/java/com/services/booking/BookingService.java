package com.services.booking;

import com.models.Booking;

import java.util.List;

public interface BookingService {

    //READ
    Booking findBookingById(Long id);
    List<Booking> findBookingsByExcursionId(Long excursionId);
    List<Booking> findBookingsByCustomerId(Long customerId);
    List<Booking> findAllBookings();
    //CREATE
    Booking saveBooking(Booking booking);
    //UPDATE
    Booking editBooking(Booking newBooking);
    //DELETE
    void deleteBooking(Long id);
}

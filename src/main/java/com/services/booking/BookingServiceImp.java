package com.services.booking;

import com.exceptions.BookingNotFoundException;
import com.models.Booking;
import com.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Booking findBookingById(Long id) {
        return findAllBookings().stream().filter(booking->booking.getId()==id).findFirst()
                .orElseThrow(()->new BookingNotFoundException(String.format("Booking with id %d not found", id)));
    }

    @Override
    public List<Booking> findBookingsByExcursionId(Long excursionId) {
        return findAllBookings().stream().filter(booking -> booking.getExcursion().getId()==excursionId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findBookingsByCustomerId(Long customerId) {
        return findAllBookings().stream().filter(booking -> booking.getCustomer().getId() == customerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findAllBookings(){
        return bookingRepo.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    //TODO
    @Override
    public Booking editBooking(Booking newBooking) {

        return bookingRepo.save(newBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepo.delete(id);
    }
}

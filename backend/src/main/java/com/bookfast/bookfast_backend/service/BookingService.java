package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.entity.Booking;
import com.bookfast.bookfast_backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {

        boolean alreadyBooked =
                bookingRepository.existsByShowIdAndSeatId(
                        booking.getShow().getId(),
                        booking.getSeat().getId()
                );

        if (alreadyBooked) {
            throw new RuntimeException("Seat is already booked for this show");
        }

        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
}
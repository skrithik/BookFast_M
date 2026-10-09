package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.entity.Booking;
import com.bookfast.bookfast_backend.entity.BookingStatus;
import com.bookfast.bookfast_backend.repository.BookingRepository;
import org.springframework.stereotype.Service;
import com.bookfast.bookfast_backend.exception.SeatAlreadyBookedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.bookfast.bookfast_backend.dto.BookingResponse;
import com.bookfast.bookfast_backend.repository.UserRepository;
import com.bookfast.bookfast_backend.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingService(
        BookingRepository bookingRepository,
        UserRepository userRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public List<BookingResponse> getAllBookings() {

        return bookingRepository.findAll()
                .stream()
                .map(booking -> new BookingResponse(
                        booking.getId(),
                        booking.getUser().getName(),
                        booking.getUser().getEmail(),
                        booking.getShow().getId(),
                        booking.getSeat().getId(),
                        booking.getBookedAt(),
                        booking.getStatus()
                ))
                .toList();
    }

    public BookingResponse createBooking(Booking booking) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String loggedInEmail = authentication.getName();

        User loggedInUser = userRepository
                .findByEmail(loggedInEmail)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        if (bookingRepository.existsByShowIdAndSeatIdAndStatus(
                booking.getShow().getId(),
                booking.getSeat().getId(),
                BookingStatus.CONFIRMED
        )) {

        throw new SeatAlreadyBookedException(
                "Seat is already booked for this show"
        );
        }

        booking.setUser(loggedInUser);
        booking.setStatus(BookingStatus.CONFIRMED);

        Booking savedBooking = bookingRepository.save(booking);

        return new BookingResponse(
                savedBooking.getId(),
                savedBooking.getUser().getName(),
                savedBooking.getUser().getEmail(),
                savedBooking.getShow().getId(),
                savedBooking.getSeat().getId(),
                savedBooking.getBookedAt(),
                savedBooking.getStatus()
        );
    }

    public List<BookingResponse> getMyBookings() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String loggedInEmail = authentication.getName();

        List<Booking> bookings =
                bookingRepository.findByUserEmail(loggedInEmail);

        return bookings.stream()
                .map(booking -> new BookingResponse(
                        booking.getId(),
                        booking.getUser().getName(),
                        booking.getUser().getEmail(),
                        booking.getShow().getId(),
                        booking.getSeat().getId(),
                        booking.getBookedAt(),
                        booking.getStatus()
                ))
                .toList();
    }

    public BookingResponse cancelBooking(Long bookingId) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String loggedInEmail = authentication.getName();

        Booking booking = bookingRepository
                .findByIdAndUserEmail(bookingId, loggedInEmail)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Booking not found"
                        )
                );

        if (booking.getStatus() == BookingStatus.CANCELLED) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Booking is already cancelled"
        );
        }

        booking.setStatus(BookingStatus.CANCELLED);

        Booking cancelledBooking = bookingRepository.save(booking);

        return new BookingResponse(
                cancelledBooking.getId(),
                cancelledBooking.getUser().getName(),
                cancelledBooking.getUser().getEmail(),
                cancelledBooking.getShow().getId(),
                cancelledBooking.getSeat().getId(),
                cancelledBooking.getBookedAt(),
                cancelledBooking.getStatus()
        );
    }

    public BookingResponse getBookingById(Long bookingId) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String loggedInEmail = authentication.getName();

        Booking booking = bookingRepository
                .findByIdAndUserEmail(bookingId, loggedInEmail)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Booking not found"
                        )
                );

        return new BookingResponse(
                booking.getId(),
                booking.getUser().getName(),
                booking.getUser().getEmail(),
                booking.getShow().getId(),
                booking.getSeat().getId(),
                booking.getBookedAt(),
                booking.getStatus()
        );
    }
}
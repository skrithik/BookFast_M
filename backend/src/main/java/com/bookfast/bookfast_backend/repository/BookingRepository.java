package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookfast.bookfast_backend.entity.BookingStatus;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByShowIdAndSeatIdAndStatus(
            Long showId,
            Long seatId,
            BookingStatus status
    );

    List<Booking> findByUserEmail(String email);

    Optional<Booking> findByIdAndUserEmail(Long id, String email);
}
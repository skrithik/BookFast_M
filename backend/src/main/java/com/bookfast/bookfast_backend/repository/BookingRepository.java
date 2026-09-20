package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
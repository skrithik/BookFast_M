package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
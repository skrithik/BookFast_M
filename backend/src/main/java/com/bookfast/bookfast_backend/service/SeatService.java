package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.entity.Seat;
import com.bookfast.bookfast_backend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }
}
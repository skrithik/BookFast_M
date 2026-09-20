package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
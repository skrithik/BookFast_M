package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.dto.CreateEventRequest;
import com.bookfast.bookfast_backend.entity.Event;
import com.bookfast.bookfast_backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(CreateEventRequest request) {

        Event event = new Event(
                request.getName(),
                request.getDescription(),
                request.getEventDate()
        );

        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
}
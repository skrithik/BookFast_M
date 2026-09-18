package com.bookfast.bookfast_backend.dto;

import java.time.LocalDateTime;

public class UpdateEventRequest {

    private String name;
    private String description;
    private LocalDateTime eventDate;

    public UpdateEventRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
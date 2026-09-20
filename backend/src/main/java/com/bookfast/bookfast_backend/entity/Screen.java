package com.bookfast.bookfast_backend.entity;

import jakarta.persistence.*;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    public Screen() {
    }

    public Screen(String name, Venue venue) {
        this.name = name;
        this.venue = venue;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
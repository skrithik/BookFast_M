package com.bookfast.bookfast_backend.entity;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    public Seat() {
    }

    public Seat(String seatNumber, Screen screen) {
        this.seatNumber = seatNumber;
        this.screen = screen;
    }

    public Long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
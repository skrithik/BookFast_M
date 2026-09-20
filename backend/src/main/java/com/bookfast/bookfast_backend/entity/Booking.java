package com.bookfast.bookfast_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    private LocalDateTime bookedAt;

    public Booking() {
    }

    public Booking(User user, Show show, Seat seat, LocalDateTime bookedAt) {
        this.user = user;
        this.show = show;
        this.seat = seat;
        this.bookedAt = bookedAt;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }
}
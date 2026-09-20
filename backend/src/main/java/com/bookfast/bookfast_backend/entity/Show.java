package com.bookfast.bookfast_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    private LocalDate showDate;

    @Enumerated(EnumType.STRING)
    private ShowSlot slot;

    public Show() {
    }

    public Show(Movie movie, Screen screen, LocalDate showDate, ShowSlot slot) {
        this.movie = movie;
        this.screen = screen;
        this.showDate = showDate;
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public ShowSlot getSlot() {
        return slot;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setSlot(ShowSlot slot) {
        this.slot = slot;
    }
}
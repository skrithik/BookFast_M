package com.bookfast.bookfast_backend.dto;

import com.bookfast.bookfast_backend.entity.BookingStatus;

import java.time.LocalDateTime;

public class BookingResponse {

    private Long id;
    private String userName;
    private String userEmail;
    private Long showId;
    private Long seatId;
    private LocalDateTime bookedAt;
    private BookingStatus status;

    public BookingResponse(
            Long id,
            String userName,
            String userEmail,
            Long showId,
            Long seatId,
            LocalDateTime bookedAt,
            BookingStatus status
    ) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.showId = showId;
        this.seatId = seatId;
        this.bookedAt = bookedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getShowId() {
        return showId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
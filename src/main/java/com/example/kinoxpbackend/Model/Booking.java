package com.example.kinoxpbackend.Model;


import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private Long id;
    private User user;  // Den bruger, der har lavet bookingen
    private Screening screening;  // Forestillingen, som der er booket billetter til
    private List<Seat> seats;  // Sæderne, der er booket
    private LocalDateTime bookingTime;  // Tidspunktet for bookingen

    // Konstruktør, getters og setters
    public Booking(Long id, User user, Screening screening, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.screening = screening;
        this.seats = seats;
        this.bookingTime = LocalDateTime.now();  // Bookingtidspunkt er det aktuelle tidspunkt
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
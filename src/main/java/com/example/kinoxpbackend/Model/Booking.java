package com.example.kinoxpbackend.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Den bruger, der har lavet bookingen

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;  // Forestillingen, som der er booket billetter til

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @ManyToMany
    @JoinTable(
            name = "booking_seat",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;  // Sæderne, der er booket

    @Column(name = "createdAt")
    private LocalDateTime bookingTime;  // Tidspunktet for bookingen

    // Konstruktør, getters og setters
    public Booking(Long id, User user, Screening screening, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.screening = screening;
        this.seats = seats;
        this.bookingTime = LocalDateTime.now();  // Bookingtidspunkt er det aktuelle tidspunkt
    }

    public Booking() {

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
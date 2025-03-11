package com.example.kinoxpbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "screening_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference("screening-tickets") // Unique reference name
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference("user-tickets") // Unique reference name
    private User user;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference("booking-tickets") // Unique reference name
    private Booking booking;

    // Constructors
    public Ticket() {}

    public Ticket(Double price, Seat seat, Screening screening, User user, Booking booking) {
        this.price = price;
        this.seat = seat;
        this.screening = screening;
        this.user = user;
        this.booking = booking;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }
    public Screening getScreening() { return screening; }
    public void setScreening(Screening screening) { this.screening = screening; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking){ this.booking = booking; }}
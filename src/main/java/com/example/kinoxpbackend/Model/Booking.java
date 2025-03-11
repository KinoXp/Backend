package com.example.kinoxpbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String movieTitle;
        private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference("user-bookings") // Prevents serialization of User
    private User user;

    @ManyToOne
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    @JsonBackReference("screening-bookings") // Prevents serialization of Screening
    private Screening screening;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("booking-tickets") // Allows serialization of Tickets
    private Set<Ticket> tickets = new HashSet<>();
    // Constructors

    public Booking() {}

    public Booking(String customerName, String movieTitle, int numberOfSeats, User user, Screening screening) {
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.numberOfSeats = numberOfSeats;
        this.user = user;
        this.screening = screening;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Screening getScreening() { return screening; }
    public void setScreening(Screening screening) { this.screening = screening; }
    public Set<Ticket> getTickets() { return tickets; }
    public void setTickets(Set<Ticket> tickets) { this.tickets = tickets; }
}
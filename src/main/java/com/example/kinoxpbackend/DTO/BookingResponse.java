package com.example.kinoxpbackend.DTO;

import java.util.Set;

public class BookingResponse {
    private Long id;
    private String customerName;
    private String movieTitle;
    private int numberOfSeats;
    private Set<TicketResponse> tickets;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Set<TicketResponse> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketResponse> tickets) {
        this.tickets = tickets;
    }
}
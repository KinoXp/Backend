package com.example.kinoxpbackend.DTO;

import java.util.List;

public class BookingRequest {
    private String customerName;
    private String movieTitle;
    private int numberOfSeats;
    private Long userId;
    private Long screeningId;
    private List<TicketRequest> tickets;

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getScreeningId() { return screeningId; }
    public void setScreeningId(Long screeningId) { this.screeningId = screeningId; }
    public List<TicketRequest> getTickets() { return tickets; }
    public void setTickets(List<TicketRequest> tickets) { this.tickets = tickets; }
}
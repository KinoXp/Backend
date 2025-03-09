package com.example.kinoxpbackend.Model;


import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rowNumber;  // Række
    private int seatNumber; // Sædenummer
    private boolean isReserved; // Er sædet reserveret?

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening; // Hvilken visning sædet tilhører

    public Seat() {}

    public Seat(int rowNumber, int seatNumber, Screening screening, boolean isReserved) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.screening = screening;
        this.isReserved = isReserved;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public int getRowNumber() { return rowNumber; }
    public void setRowNumber(int rowNumber) { this.rowNumber = rowNumber; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isReserved() { return isReserved; }
    public void setReserved(boolean reserved) { isReserved = reserved; }

    public Screening getScreening() { return screening; }
    public void setScreening(Screening screening) { this.screening = screening; }
}
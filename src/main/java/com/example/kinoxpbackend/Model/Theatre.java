package com.example.kinoxpbackend.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // F.eks. "Sal 1" eller "Sal 2"
    private int rows;
    private int seatsPerRow;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screening> screenings; // Visninger i dette teater

    public Theatre(Long id, String name, int rows, int seatsPerRow) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public Theatre() {

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }

    public int getSeatsPerRow() { return seatsPerRow; }
    public void setSeatsPerRow(int seatsPerRow) { this.seatsPerRow = seatsPerRow; }
}
package com.example.kinoxpbackend.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theatreName;
    private LocalDateTime screeningTime; // Tidspunkt for visningen

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Hvilken film der vises

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre; // Hvilket teater visningen foregår i

    @ManyToMany
    @JoinTable(
            name = "screening_seat",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats; // Sæderne, der er tilgængelige for denne visning

    // Getters og setters

    // Constructors
    public Screening() {}

    public Screening(LocalDateTime screeningTime, Movie movie) {
        this.screeningTime = screeningTime;
        this.movie = movie;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getScreeningTime() { return screeningTime; }
    public void setScreeningTime(LocalDateTime screeningTime) { this.screeningTime = screeningTime; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) {
        this.movie = movie;

    }

}
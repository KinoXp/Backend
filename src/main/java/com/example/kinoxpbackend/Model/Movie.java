package com.example.kinoxpbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int duration; // in minutes
    private int ageLimit;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("movieReference")
    private List<Screening> screenings;


    // Constructors
    public Movie() {}

    public Movie(String title, String genre, int duration, int ageLimit) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ageLimit = ageLimit;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public int getAgeLimit() { return ageLimit; }

    public void setAgeLimit(int ageLimit) { this.ageLimit = ageLimit; }

    public List<Screening> getScreenings() { return screenings; }

    public void setScreenings(List<Screening> screenings) { this.screenings = screenings; }
}

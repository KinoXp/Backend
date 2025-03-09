package com.example.kinoxpbackend.Model;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "ageLimit")
    private int ageLimit;

    @Column(name = "showTime")
    private String showTime;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Screening> screenings;  // En film kan have mange visninger


    // Konstruktor
    public Movie(int id, String title, String category, int ageLimit, String showTime) {
        this.title = title;
        this.category = category;
        this.ageLimit = ageLimit;
        this.showTime = showTime;
    }


    public Movie() {

    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
package com.example.kinoxpbackend.Model;

public class Movie {

    private String title;

    private String category;

    private int ageLimit;

    private String showTime;

    // Konstruktor
    public Movie(String title, String category, int ageLimit, String showTime) {
        this.title = title;
        this.category = category;
        this.ageLimit = ageLimit;
        this.showTime = showTime;
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
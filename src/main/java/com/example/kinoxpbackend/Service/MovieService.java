package com.example.kinoxpbackend.Service;

import com.example.kinoxpbackend.Model.Movie;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }
}
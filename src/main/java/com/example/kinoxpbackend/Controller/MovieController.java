package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.Model.Movie;
import com.example.kinoxpbackend.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Vis formularen for at tilføje en ny film
    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        return "add-movie";
    }

    @PostMapping
    public String addMovie(Movie movie) {
        movieService.addMovie(movie);  // Tilføjer filmen til listen med movieService
        return "redirect:/movies";
    }

    // Liste alle film
    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies()); // Henter alle film og tilføjer dem til modellen
        return "movie-list";
    }
}
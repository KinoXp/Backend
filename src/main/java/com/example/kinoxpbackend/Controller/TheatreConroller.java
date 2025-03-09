package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.Model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.kinoxpbackend.Service.TheatreService;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreConroller {

    @Autowired
    private final TheatreService theatreService;

    public TheatreConroller(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre);
    }

    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
    }
}
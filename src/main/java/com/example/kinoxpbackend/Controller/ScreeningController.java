package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.Model.Screening;
import com.example.kinoxpbackend.Service.ScreeningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping
    public List<Screening> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public Screening getScreeningById(@PathVariable Long id) {
        return screeningService.getScreeningById(id);
    }

    @PostMapping
    public Screening addScreening(@RequestBody Screening screening) {
        return screeningService.addScreening(screening);
    }

    @DeleteMapping("/{id}")
    public boolean deleteScreening(@PathVariable Long id) {
        return screeningService.deleteScreening(id);
    }
}
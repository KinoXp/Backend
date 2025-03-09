package com.example.kinoxpbackend.Service;

import com.example.kinoxpbackend.Model.Theatre;
import com.example.kinoxpbackend.Repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(Long id) {
        Optional<Theatre> optionalTheatre = theatreRepository.findById(id);
        return optionalTheatre.orElse(null);
    }

    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }
}
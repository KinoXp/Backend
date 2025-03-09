package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.Model.Seat;
import com.example.kinoxpbackend.Service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    @PostMapping
    public Seat addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSeat(@PathVariable Long id) {
        return seatService.deleteSeat(id);
    }
}
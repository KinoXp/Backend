package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.Model.Ticket;
import com.example.kinoxpbackend.Service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    // Konstruktor til at injecte TicketService
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Hent alle billetter
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Hent billet ved ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket == null) {
            return ResponseEntity.notFound().build(); // Returner 404, hvis billet ikke findes
        }
        return ResponseEntity.ok(ticket); // Returner 200 med billetdata
    }

    // Tilføj en ny billet
    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.addTicket(ticket);
        return ResponseEntity.status(201).body(savedTicket); // Returner 201 (Created) med den oprettede billet
    }

    // Slet en billet ved ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        boolean deleted = ticketService.deleteTicket(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Returner 204, hvis sletning lykkes
        }
        return ResponseEntity.notFound().build(); // Returner 404, hvis billet ikke findes
    }
}
package com.example.kinoxpbackend.Service;

import com.example.kinoxpbackend.Model.Ticket;
import com.example.kinoxpbackend.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    // Constructor injection af TicketRepository
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Hent alle billetter
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll(); // Henter alle billetter fra databasen
    }

    // Hent en billet ved ID
    public Ticket getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElse(null); // Returner null, hvis billet ikke findes
    }

    // Tilføj en ny billet
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket); // Gem billetten i databasen
    }

    // Slet billet ved ID
    public boolean deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id); // Slet billetten fra databasen
            return true; // Returner true, hvis billetten blev slettet
        }
        return false; // Returner false, hvis billetten ikke findes
    }
}
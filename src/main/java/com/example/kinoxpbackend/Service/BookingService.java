package com.example.kinoxpbackend.Service;

import com.example.kinoxpbackend.DTO.BookingRequest;
import com.example.kinoxpbackend.DTO.BookingResponse;
import com.example.kinoxpbackend.DTO.TicketRequest;
import com.example.kinoxpbackend.DTO.TicketResponse;
import com.example.kinoxpbackend.Model.*;
import com.example.kinoxpbackend.Repository.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    public BookingService(UserRepository userRepository, ScreeningRepository screeningRepository,
                          SeatRepository seatRepository, BookingRepository bookingRepository,
                          TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.getReferenceById(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long id) {
        bookingRepository.getReferenceById(id);
    }

    public Booking createBooking(BookingRequest bookingRequest) {
        // Fetch User and Screening from the database
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Screening screening = screeningRepository.findById(bookingRequest.getScreeningId())
                .orElseThrow(() -> new RuntimeException("Screening not found"));

        // Create a new Booking
        Booking booking = new Booking();
        booking.setCustomerName(bookingRequest.getCustomerName());
        booking.setMovieTitle(bookingRequest.getMovieTitle());
        booking.setNumberOfSeats(bookingRequest.getNumberOfSeats());
        booking.setUser(user);
        booking.setScreening(screening);

        // Save the Booking
        Booking savedBooking = bookingRepository.save(booking);

        // Create and save Tickets
        Set<Ticket> tickets = new HashSet<>();
        for (TicketRequest ticketRequest : bookingRequest.getTickets()) {
            Seat seat = seatRepository.findBySeatNumber(ticketRequest.getSeatNumber())
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            Ticket ticket = new Ticket();
            ticket.setPrice(10.0); // Example price
            ticket.setSeat(seat);
            ticket.setScreening(screening);
            ticket.setUser(user);
            ticket.setBooking(savedBooking);

            tickets.add(ticketRepository.save(ticket));
        }

        savedBooking.setTickets(tickets);
        return savedBooking;
    }
    public BookingResponse createBookings(BookingRequest bookingRequest) {
        // Fetch User and Screening from the database
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Screening screening = screeningRepository.findById(bookingRequest.getScreeningId())
                .orElseThrow(() -> new RuntimeException("Screening not found"));

        // Create a new Booking
        Booking booking = new Booking();
        booking.setCustomerName(bookingRequest.getCustomerName());
        booking.setMovieTitle(bookingRequest.getMovieTitle());
        booking.setNumberOfSeats(bookingRequest.getNumberOfSeats());
        booking.setUser(user);
        booking.setScreening(screening);

        // Save the Booking
        Booking savedBooking = bookingRepository.save(booking);

        // Create and save Tickets
        Set<Ticket> tickets = new HashSet<>();
        for (TicketRequest ticketRequest : bookingRequest.getTickets()) {
            Seat seat = seatRepository.findBySeatNumber(ticketRequest.getSeatNumber())
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            Ticket ticket = new Ticket();
            ticket.setPrice(10.0); // Example price
            ticket.setSeat(seat);
            ticket.setScreening(screening);
            ticket.setUser(user);
            ticket.setBooking(savedBooking);

            tickets.add(ticketRepository.save(ticket));
        }

        savedBooking.setTickets(tickets);

        // Convert to BookingResponse
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setId(savedBooking.getId());
        bookingResponse.setCustomerName(savedBooking.getCustomerName());
        bookingResponse.setMovieTitle(savedBooking.getMovieTitle());
        bookingResponse.setNumberOfSeats(savedBooking.getNumberOfSeats());

        Set<TicketResponse> ticketResponses = new HashSet<>();
        for (Ticket ticket : savedBooking.getTickets()) {
            TicketResponse ticketResponse = new TicketResponse();
            ticketResponse.setId(ticket.getId());
            ticketResponse.setPrice(ticket.getPrice());
            ticketResponse.setSeatNumber(ticket.getSeat().getSeatNumber());
            ticketResponses.add(ticketResponse);
        }
        bookingResponse.setTickets(ticketResponses);

        return bookingResponse;
    }
}
package com.example.kinoxpbackend.Controller;

import com.example.kinoxpbackend.DTO.BookingRequest;
import com.example.kinoxpbackend.DTO.BookingResponse;
import com.example.kinoxpbackend.Model.Booking;
import com.example.kinoxpbackend.Service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bookings")  // Base path for all booking operations
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Hent alle bookinger
    @GetMapping("/getAllBooking")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Hent en specifik booking via ID
    @GetMapping("/getBooking/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    // Opret en ny booking
    @PostMapping("/bookings")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            BookingResponse bookingResponse = bookingService.createBookings(bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Slet en booking via ID
    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
package com.example.kinoxpbackend.Service;

import com.example.kinoxpbackend.Model.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();
    private Long nextId = 1L;

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    public Booking getBookingById(Long id) {
        return bookings.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public Booking createBooking(Booking booking) {
        booking.setId(nextId++);
        bookings.add(booking);
        return booking;
    }

    public boolean deleteBooking(Long id) {
        return bookings.removeIf(b -> b.getId().equals(id));
    }
}
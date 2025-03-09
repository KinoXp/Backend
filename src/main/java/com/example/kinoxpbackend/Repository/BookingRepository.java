package com.example.kinoxpbackend.Repository;

import com.example.kinoxpbackend.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

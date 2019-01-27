package com.kasthuri.bookingservice.repository;

import com.kasthuri.bookingservice.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingModel, String> {
    Optional<Iterable<BookingModel>> findByStatus(String status);

    Optional<Iterable<BookingModel>> findByStylistIdAndStatus(String stylistId, String status);

    Optional<Iterable<BookingModel>> findBySalonIdAndStatus(String salonId, String status);
}

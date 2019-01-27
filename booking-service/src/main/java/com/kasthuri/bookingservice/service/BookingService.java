package com.kasthuri.bookingservice.service;

import com.kasthuri.bookingservice.model.BookingModel;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingModel save(BookingModel bookingModel);

    List<BookingModel> getAllBookings();

    Optional<Iterable<BookingModel>> findByStatus(String status);

    Optional<BookingModel> findById(String id);

    Optional<Iterable<BookingModel>> findByStylistIdAndStatus(String id, String status);

    Optional<Iterable<BookingModel>> findBySalonIdAndStatus(String id, String status);

    Optional<Iterable<BookingModel>> findByStylistId(String id);
}

package com.kasthuri.bookingservice.service;

import com.kasthuri.bookingservice.model.BookingModel;
import com.kasthuri.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookingServiceImpl")
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    @Override
    public BookingModel save(BookingModel bookingModel) {
        return this.bookingRepository.save(bookingModel);
    }

    @Override
    public List<BookingModel> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Optional<Iterable<BookingModel>> findByStatus(String status) {
        return this.bookingRepository.findByStatus(status);
    }

    @Override
    public Optional<BookingModel> findById(String id) {
        return this.bookingRepository.findById(id);
    }

    @Autowired
    public void setBookingRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}

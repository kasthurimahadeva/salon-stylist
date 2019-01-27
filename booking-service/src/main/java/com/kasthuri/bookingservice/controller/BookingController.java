package com.kasthuri.bookingservice.controller;

import com.kasthuri.bookingservice.model.BookingModel;
import com.kasthuri.bookingservice.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/booking/v1")
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/request")
    public BookingModel bookStylist(@RequestBody BookingModel bookingModel) {
        return this.bookingService.save(bookingModel);
    }

    @GetMapping("/bookings")
    public List<BookingModel> getBookingLists() {
        return this.bookingService.getAllBookings();
    }

    @GetMapping("/salon/{salonId}/{status}")
    public Iterable<BookingModel> findByStatusOfSalon(@PathVariable String salonId, @PathVariable String status) {
        Optional<Iterable<BookingModel>> bookingList = this.bookingService.findBySalonIdAndStatus(salonId, status);
        if (bookingList.isPresent()) {
            return bookingList.get();
        }
        return null;
    }

    @GetMapping("/stylist/{stylistId}/{status}")
    public Iterable<BookingModel> findByStatusOfStylist(@PathVariable String stylistId, @PathVariable String status) {
        Optional<Iterable<BookingModel>> bookingList = this.bookingService.findByStylistIdAndStatus(stylistId, status);
        if (bookingList.isPresent()) {
            return bookingList.get();
        }
        return null;
    }

    @PutMapping("/completed-requests/{id}/{accepted}")
    public BookingModel updateStatus(@PathVariable("id") String id, @PathVariable("accepted") boolean accepted) {
        Optional<BookingModel> existBooking = this.bookingService.findById(id);
        BookingModel updatedBooking;
        if (existBooking.isPresent()) {
            updatedBooking = existBooking.get();
            if (accepted) {
                updatedBooking.setStatus("accepted");
                existBooking.get().setStatus("accepted");
            } else {
                updatedBooking.setStatus("rejected");
                existBooking.get().setStatus("rejected");
            }
            BeanUtils.copyProperties(updatedBooking, existBooking);
            this.bookingService.save(existBooking.get());
            return existBooking.get();
        }
        return null;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}

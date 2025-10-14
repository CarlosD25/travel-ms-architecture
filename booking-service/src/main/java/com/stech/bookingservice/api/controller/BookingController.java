package com.stech.bookingservice.api.controller;

import com.stech.bookingservice.api.dto.CreateReservationRequest;
import com.stech.bookingservice.api.dto.Money;
import com.stech.bookingservice.api.dto.ReservationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/booking/v1")
public class BookingController {

    @PostMapping("/reservations")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody CreateReservationRequest request) throws InterruptedException {

        Thread.sleep(2000);

        ReservationDto response = new ReservationDto(
                "RES-9001001",
                "CONFIRMED",
                "H-77XYZ",
                new Money(new BigDecimal("1890.50"), "USD")
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/reservations/{reservationId}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable String reservationId) {

        if ("RES-9001001".equals(reservationId)) {
            ReservationDto reservation = new ReservationDto(
                    "RES-9001001",
                    "CONFIRMED",
                    "H-77XYZ",
                    new Money(new BigDecimal("1890.50"), "USD")
            );
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.stech.itineraryservice.controller;

import com.stech.itineraryservice.dto.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/itinerary/v1")
public class ItineraryController {

    @GetMapping("/details/{id}")
    public ResponseEntity<ItineraryDto> getItineraryDetails(@PathVariable String id) throws InterruptedException {
        Thread.sleep(2000);

        if (!id.equals("ITI-BOG-MAD-20251210-20251220-001")) {
            return ResponseEntity.notFound().build();
        }

        ItineraryDto itinerary = new ItineraryDto(
                id,
                new Money("USD", new BigDecimal("1890.50")),
                new FlightInfo(
                        new FlightLeg(
                                "IB",
                                "IB6584",
                                OffsetDateTime.parse("2025-12-10T21:10:00-05:00"),
                                OffsetDateTime.parse("2025-12-11T12:10:00+01:00"),
                                0
                        ),
                        new FlightLeg(
                                "IB",
                                "IB6583",
                                OffsetDateTime.parse("2025-12-20T15:30:00+01:00"),
                                OffsetDateTime.parse("2025-12-20T20:30:00-05:00"),
                                0
                        )
                ),
                new HotelInfo(
                        "Hotel Gran Vía Madrid",
                        LocalDate.parse("2025-12-11"),
                        LocalDate.parse("2025-12-20"),
                        "Doble + extra",
                        4.5
                )
        );

        return ResponseEntity.ok(itinerary);
    }

    @GetMapping("/search")
    @Cacheable("searches")
    public SearchResponse searchItineraries(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
            @RequestParam int adults,
            @RequestParam int children,
            @RequestParam int rooms
    ) throws InterruptedException {

        Thread.sleep(3000);

        ItineraryDto exampleItinerary = new ItineraryDto(
                "ITI-BOG-MAD-20251210-20251220-001",
                new Money("USD", new BigDecimal("1890.50")),
                new FlightInfo(
                        new FlightLeg(
                                "IB",
                                "IB6584",
                                OffsetDateTime.parse("2025-12-10T21:10:00-05:00"),
                                OffsetDateTime.parse("2025-12-11T12:10:00+01:00"),
                                0
                        ),
                        new FlightLeg(
                                "IB",
                                "IB6583",
                                OffsetDateTime.parse("2025-12-20T15:30:00+01:00"),
                                OffsetDateTime.parse("2025-12-20T20:30:00-05:00"),
                                0
                        )
                ),
                new HotelInfo(
                        "Hotel Gran Vía Madrid",
                        LocalDate.parse("2025-12-11"),
                        LocalDate.parse("2025-12-20"),
                        "Doble + extra",
                        4.5
                )
        );

        SearchResponse response = new SearchResponse();
        response.setItineraries(List.of(exampleItinerary));
        response.setSearchId("SRCH-9c2b");

        return response;
    }

}

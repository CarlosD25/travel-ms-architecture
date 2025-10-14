package com.stech.bookingservice.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {
    private String itineraryId;
    private FlightRef flightRef;
    private List<Guest> guests;
    private Payment payment;
    private Contact contact;
}

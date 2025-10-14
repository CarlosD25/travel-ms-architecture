package com.stech.bookingservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRef {
    private String pnr;
    private String carrier;
    private boolean ticketing;
}

package com.stech.itineraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryDto implements Serializable {
    String id; Money price; FlightInfo flight; HotelInfo hotel;
}

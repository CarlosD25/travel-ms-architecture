package com.stech.itineraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightInfo implements Serializable {
    FlightLeg outbound; FlightLeg inbound;
}

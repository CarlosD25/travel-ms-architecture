package com.stech.itineraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightLeg implements Serializable {
    String carrier; String number; OffsetDateTime depart; OffsetDateTime arrive; int stops;
}

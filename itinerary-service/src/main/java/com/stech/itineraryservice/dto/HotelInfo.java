package com.stech.itineraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelInfo implements Serializable {
    String name; LocalDate checkIn; LocalDate checkOut; String roomType; double rating;
}

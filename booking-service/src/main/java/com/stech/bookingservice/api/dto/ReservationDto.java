package com.stech.bookingservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private String reservationId;
    private String status;
    private String hotelConfirmation;
    private Money total;
}

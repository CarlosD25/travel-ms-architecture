package com.stech.bookingservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private String firstName;
    private String lastName;
    private PaxType type;
}

package com.stech.itineraryservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponse implements Serializable {
    List<ItineraryDto> itineraries;
    String searchId;
}

package com.stech.gatewayservice.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/booking")
    public ResponseEntity<String> bookingFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorMessage("booking-service"));
    }

    @GetMapping("/itinerary")
    public ResponseEntity<String> itineraryFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorMessage("itinerary-service"));
    }

    private String errorMessage(String service) {
        return "El servicio '" + service + "' no está disponible actualmente. Intente más tarde.";
    }

}

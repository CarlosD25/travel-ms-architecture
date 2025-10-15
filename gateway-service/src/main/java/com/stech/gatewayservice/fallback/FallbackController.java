package com.stech.gatewayservice.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping(value = "/booking", method = {
            RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.PATCH
    })
    public ResponseEntity<String> bookingFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorMessage("booking-service"));
    }

    @RequestMapping(value = "/itinerary", method = {
            RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.PATCH
    })
    public ResponseEntity<String> itineraryFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorMessage("itinerary-service"));
    }

    private String errorMessage(String service) {
        return "El servicio '" + service + "' no está disponible actualmente. Intente más tarde.";
    }

}

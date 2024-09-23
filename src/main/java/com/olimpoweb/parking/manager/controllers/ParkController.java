package com.olimpoweb.parking.manager.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olimpoweb.parking.manager.entities.Slot;
import com.olimpoweb.parking.manager.models.requests.ParkRequest;
import com.olimpoweb.parking.manager.models.responses.ParkResponse;
import com.olimpoweb.parking.manager.services.ParkService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/park")
@RequiredArgsConstructor
public class ParkController {

    private final ParkService parkService;
    @PostMapping("/park")
    public ResponseEntity<ParkResponse> parkIn(@RequestBody ParkRequest request) {
        return ResponseEntity.ok(parkService.parkIn(request));
    }

    @PostMapping("/unpark")
    public ResponseEntity<ParkResponse> parkOut(@RequestBody ParkRequest request) {
        return ResponseEntity.ok(parkService.parkOut(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Slot>> parkSlots() {
        return ResponseEntity.ok(parkService.parkSlots());
    }

    // @PostMapping("/slot")
    // public ResponseEntity<JwtAuthResponse> slot(@RequestBody SignInRequest request) {
    //     return ResponseEntity.ok(authService.signin(request));
    // }
}
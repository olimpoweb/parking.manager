package com.olimpoweb.parking.manager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olimpoweb.parking.manager.models.requests.SignInRequest;
import com.olimpoweb.parking.manager.models.requests.SignUpRequest;
import com.olimpoweb.parking.manager.models.responses.JwtAuthResponse;
import com.olimpoweb.parking.manager.services.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/park")
@RequiredArgsConstructor
public class ParkController {
    private final AuthService authService;
    @PostMapping("/park")
    public ResponseEntity<JwtAuthResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/unpark")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authService.signin(request));
    }

    @PostMapping("/slot")
    public ResponseEntity<JwtAuthResponse> slot(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authService.signin(request));
    }
}
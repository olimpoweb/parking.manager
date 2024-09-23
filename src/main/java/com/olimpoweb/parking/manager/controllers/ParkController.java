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
import com.olimpoweb.parking.manager.models.requests.SlotRequest;
import com.olimpoweb.parking.manager.models.responses.ParkResponse;
import com.olimpoweb.parking.manager.models.responses.SlotResponse;
import com.olimpoweb.parking.manager.services.ParkService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/park")
@RequiredArgsConstructor
@Tag(name = "Park API")
public class ParkController {

    private final ParkService parkService;
    
    /** Save a car entering the parking lot */
    @Operation(
            summary = "Save a car entering the parking lot",
            description = "Save a car entering the")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/park")
    public ResponseEntity<ParkResponse> parkIn(@RequestBody ParkRequest request) {
        return ResponseEntity.ok(parkService.parkIn(request));
    }

    /**
     * Save a car leaving the parking lot
     */
    @Operation(
            summary = "Save a car leaving the parking lot",
            description = "Save a car leaving the")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/unpark")
    public ResponseEntity<ParkResponse> parkOut(@RequestBody ParkRequest request) {
        return ResponseEntity.ok(parkService.parkOut(request));
    }

    /** Returns the list of slots */
    @Operation(
            summary = "Returns the list of slots",
            description = "Returns the list of slots")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Slot>> parkSlots() {
        return ResponseEntity.ok(parkService.parkSlots());
    }

    /** Returns the status of a slot by passing its id */
    @Operation(
            summary = "Returns the status of a slot by passing its id",
            description = "Returns the status of a slot by passing its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/slot")
    public ResponseEntity<SlotResponse> slot(@RequestBody SlotRequest request) {
        return ResponseEntity.ok(parkService.getSlotById(request));
    }
}
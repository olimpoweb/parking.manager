package com.olimpoweb.parking.manager.models.responses;

import com.olimpoweb.parking.manager.entities.Slot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkResponse {

    private Slot slot;
    
}

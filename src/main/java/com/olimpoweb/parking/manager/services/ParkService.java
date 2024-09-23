package com.olimpoweb.parking.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.olimpoweb.parking.manager.entities.Slot;
import com.olimpoweb.parking.manager.exceptions.LicensePlateAlreadyInException;
import com.olimpoweb.parking.manager.exceptions.NoFreeSlotException;
import com.olimpoweb.parking.manager.exceptions.NoLicensePlaceInException;
import com.olimpoweb.parking.manager.models.requests.ParkRequest;
import com.olimpoweb.parking.manager.models.responses.ParkResponse;
import com.olimpoweb.parking.manager.repositories.ParkRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkService {

  @Autowired
  private final ParkRepository parkRepository;

  public ParkResponse parkIn(ParkRequest request) {

      var freeSlots = parkRepository.findByLicensePlateIsNull();
      
      if (freeSlots.isEmpty()) {
          log.error("No free slots, park is full");
          throw new NoFreeSlotException("No free slots, park is full");
      }

      Slot slot = freeSlots.get(0);

      try {
          log.info(request.getLicensePlate());
          slot.setLicensePlate(request.getLicensePlate());
          parkRepository.save(slot);
      } catch (DataIntegrityViolationException e) {
          log.error("A car with this license has already been parked");
          throw new LicensePlateAlreadyInException("A car with this license has already been parked");
      }

      return ParkResponse.builder()
      .slot(slot).build();

  }

  public ParkResponse parkOut(ParkRequest request) {
  
      Slot slot = parkRepository.findByLicensePlate(request.getLicensePlate())
      .orElseThrow(() -> new NoLicensePlaceInException("No car present for this license"));

      slot.setLicensePlate(null);
      parkRepository.save(slot);
      
      return ParkResponse.builder()
      .slot(slot).build();

  }

  public List<Slot> parkSlots() {

        List<Slot> slots = parkRepository.findAll().stream().toList();

        return slots;
  }

}

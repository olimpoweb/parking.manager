package com.olimpoweb.parking.manager.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olimpoweb.parking.manager.entities.Slot;

@Repository
public interface ParkRepository extends JpaRepository<Slot, UUID>  {

    Optional<Slot> findById(UUID id);

    List<Slot> findByLicensePlateIsNull();

    List<Slot> findAll();

    Optional<Slot> findByLicensePlate(String licensePlate);

}

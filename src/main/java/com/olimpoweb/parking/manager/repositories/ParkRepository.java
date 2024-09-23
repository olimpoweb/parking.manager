package com.olimpoweb.parking.manager.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olimpoweb.parking.manager.entities.Slot;

@Repository
public interface ParkRepository extends JpaRepository<Slot, UUID>  {

    @SuppressWarnings("null")
    /**
    * Find a slot by id
    * @param id
    */
    Optional<Slot> findById(UUID id);

    /**
     * Find a slot by license plate
     */
    List<Slot> findByLicensePlateIsNull();

    @SuppressWarnings("null")
    /**
    * Find all slots
    */
    List<Slot> findAll();

    /** 
    * Find a slot by license plate
    * @param licensePlate
    */
    Optional<Slot> findByLicensePlate(String licensePlate);

}

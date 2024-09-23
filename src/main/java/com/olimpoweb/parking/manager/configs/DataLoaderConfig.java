package com.olimpoweb.parking.manager.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olimpoweb.parking.manager.entities.Slot;
import com.olimpoweb.parking.manager.repositories.ParkRepository;

@Component
public class DataLoaderConfig implements CommandLineRunner {

    private final ParkRepository parkRepository;

    @Value("${config.slots}")
    private int slotsToCreate;

    public DataLoaderConfig(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < this.slotsToCreate; i++) { 
            parkRepository.save(new Slot()); 
        }
    }
}

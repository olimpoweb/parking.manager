package com.olimpoweb.parking.manager.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.olimpoweb.parking.manager.entities.Slot;
import com.olimpoweb.parking.manager.entities.User;
import com.olimpoweb.parking.manager.models.enums.RoleEnum;
import com.olimpoweb.parking.manager.repositories.ParkRepository;
import com.olimpoweb.parking.manager.repositories.UserRepository;

/** Data insert in build project */
@Component
public class DataLoaderConfig implements CommandLineRunner {

    private final ParkRepository parkRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${config.slots}")
    private int slotsToCreate; // Slots to create in database

    public DataLoaderConfig(
        ParkRepository parkRepository,
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.parkRepository = parkRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Create n {config.slots} slots for parking area
        for (int i = 0; i < this.slotsToCreate; i++) { 
            this.parkRepository.save(new Slot()); 
        }

        // Create an admin user
        this.userRepository.save(new User("admin", "admin", "admin@admin.com", passwordEncoder.encode("admin"), RoleEnum.ADMIN));
    
    }

}

package com.example.Parking.config;

import com.example.Parking.model.Parking;
import com.example.Parking.repository.ParkingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ParkingRepository repository) {
        return args -> {
            long count = repository.count();
            if (count < 7) { // Ensures total 7 slots
                for (int i = 0; i < 7 - count; i++) {
                    Parking slot = new Parking();
                    slot.setOccupy(false);
                    repository.save(slot);
                }
            }
        };
    }
}
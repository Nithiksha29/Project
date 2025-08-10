package com.example.Parking.controller;

import com.example.Parking.model.Parking;
import com.example.Parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    ParkingService ps;

    @PostMapping("/slot")
    public Parking park()
    {
        return ps.park();
    }
    @PostMapping("/park/{carNo}")
    public String parkCar(@PathVariable String carNo)
    {
       return ps.parkCar(carNo);
    }

    @PutMapping("/park/remove/{carNo}")
    public String removeCar(@PathVariable String carNo)
    {
        return ps.removeCar(carNo);
    }

    @GetMapping("/parking")
    public List<Parking> getAllParking()
    {
        return ps.getAllParks();
    }

    @GetMapping("/parked")
    public List<Parking> getAllParkedCars() {
        return ps.getAllParkedCars();
    }



}

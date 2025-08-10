package com.example.Parking.service;

import com.example.Parking.model.Parking;
import com.example.Parking.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingService {
    @Autowired
    ParkingRepository pr;

    public List<Parking> getAllParks() {
        return pr.findAll();
    }


    public Parking park() {
        Parking p=new Parking();
        p.setOccupy(false);
        return pr.save(p);
    }

    public String parkCar(String carNo) {
        Parking slot = pr.findTopByOccupyFalse();
        if(slot==null)
        {
            return "No slots";
        }
        slot.setOccupy(true);
        slot.setCarNo(carNo);
        pr.save(slot);
        return "parked";
    }

    public String removeCar(String carNo) {
        Parking free=pr.findByCarNo(carNo);
        if(free==null)
        {
            return "Car not found";
        }
        free.setOccupy(false);
        free.setCarNo(null);
        pr.save(free);
        return "Car removed";
    }

    public List<Parking> getAllParkedCars() {
        return pr.findAllByOccupyTrue();
    }

}

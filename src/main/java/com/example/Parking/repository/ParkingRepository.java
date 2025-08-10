package com.example.Parking.repository;

import com.example.Parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking,Long> {


    Parking findTopByOccupyFalse();

    Parking findByCarNo(String carNo);

    List<Parking> findAllByOccupyTrue();

}

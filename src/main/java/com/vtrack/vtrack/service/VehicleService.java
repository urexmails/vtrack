package com.vtrack.vtrack.service;

import com.vtrack.vtrack.entity.Vehicle;
import com.vtrack.vtrack.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    public Vehicle addVehicle(Vehicle vehicle){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        vehicle.setCreated(timestamp);
        vehicle.setLastModified(timestamp);
        vehicle.setLastModifiedUser("Rex");
        vehicleRepository.save(vehicle);
        return vehicle;
    }
    public List<Vehicle> getVehiclesBySeatCount(Integer seatCount){
        return vehicleRepository.findBySeatsCount(seatCount);
    }
}

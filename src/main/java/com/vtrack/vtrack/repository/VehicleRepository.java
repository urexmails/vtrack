package com.vtrack.vtrack.repository;

import com.vtrack.vtrack.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findBySeatsCount(Integer seatsCount);
}

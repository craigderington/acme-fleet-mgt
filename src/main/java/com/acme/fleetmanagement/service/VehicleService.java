package com.acme.fleetmanagement.service;

import com.acme.fleetmanagement.model.Vehicle;
import java.util.List;
import java.util.UUID;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle findVehicleById(UUID id);
    List<Vehicle> findAllVehicles();
    void deleteVehicle(UUID id);
}

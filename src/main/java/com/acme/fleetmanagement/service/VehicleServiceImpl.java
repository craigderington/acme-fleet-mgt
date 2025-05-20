package com.acme.fleetmanagement.service;

import com.acme.fleetmanagement.model.Vehicle;
import com.acme.fleetmanagement.repository.VehicleRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findVehicleById(UUID id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteVehicle(UUID id) {
        vehicleRepository.deleteById(id);
    }
}

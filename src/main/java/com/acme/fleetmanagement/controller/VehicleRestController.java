package com.acme.fleetmanagement.controller;

import com.acme.fleetmanagement.model.Vehicle;
import com.acme.fleetmanagement.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleRestController {
    private final VehicleService vehicleService;

    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable UUID id) {
        Vehicle vehicle = vehicleService.findVehicleById(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable UUID id, @RequestBody Vehicle vehicle) {
        Vehicle existing = vehicleService.findVehicleById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        vehicle.setId(id);
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        Vehicle existing = vehicleService.findVehicleById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}

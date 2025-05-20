package com.acme.fleetmanagement.repository;

import com.acme.fleetmanagement.model.Vehicle;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}

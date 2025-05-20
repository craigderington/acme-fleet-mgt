package com.acme.fleetmanagement.repository;

import com.acme.fleetmanagement.model.ServiceRecord;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, UUID> {
}

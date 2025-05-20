package com.acme.fleetmanagement.service;

import com.acme.fleetmanagement.model.ServiceRecord;
import java.util.List;
import java.util.UUID;

public interface ServiceRecordService {
    ServiceRecord saveServiceRecord(ServiceRecord serviceRecord);
    ServiceRecord findServiceRecordById(UUID id);
    List<ServiceRecord> findAllServiceRecords();
    void deleteServiceRecord(UUID id);
}

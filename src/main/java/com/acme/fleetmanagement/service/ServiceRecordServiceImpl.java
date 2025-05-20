package com.acme.fleetmanagement.service;

import com.acme.fleetmanagement.model.ServiceRecord;
import com.acme.fleetmanagement.repository.ServiceRecordRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ServiceRecordServiceImpl implements ServiceRecordService {
    private final ServiceRecordRepository serviceRecordRepository;

    public ServiceRecordServiceImpl(ServiceRecordRepository serviceRecordRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
    }

    @Override
    public ServiceRecord saveServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    @Override
    public ServiceRecord findServiceRecordById(UUID id) {
        return serviceRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<ServiceRecord> findAllServiceRecords() {
        return serviceRecordRepository.findAll();
    }

    @Override
    public void deleteServiceRecord(UUID id) {
        serviceRecordRepository.deleteById(id);
    }
}
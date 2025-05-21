package com.acme.fleetmanagement.controller;

import com.acme.fleetmanagement.model.ServiceRecord;
import com.acme.fleetmanagement.service.ServiceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service-records")
public class ServiceRecordRestController {
    private final ServiceRecordService serviceRecordService;

    public ServiceRecordRestController(ServiceRecordService serviceRecordService) {
        this.serviceRecordService = serviceRecordService;
    }

    @GetMapping
    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordService.findAllServiceRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRecord> getServiceRecordById(@PathVariable UUID id) {
        ServiceRecord record = serviceRecordService.findServiceRecordById(id);
        return record != null ? ResponseEntity.ok(record) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ServiceRecord createServiceRecord(@RequestBody ServiceRecord serviceRecord) {
        return serviceRecordService.saveServiceRecord(serviceRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRecord> updateServiceRecord(@PathVariable UUID id, @RequestBody ServiceRecord serviceRecord) {
        ServiceRecord existing = serviceRecordService.findServiceRecordById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        serviceRecord.setId(id);
        return ResponseEntity.ok(serviceRecordService.saveServiceRecord(serviceRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRecord(@PathVariable UUID id) {
        ServiceRecord existing = serviceRecordService.findServiceRecordById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        serviceRecordService.deleteServiceRecord(id);
        return ResponseEntity.noContent().build();
    }
}

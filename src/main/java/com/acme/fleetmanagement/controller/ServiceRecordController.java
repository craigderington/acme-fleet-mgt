package com.acme.fleetmanagement.controller;

import com.acme.fleetmanagement.model.ServiceRecord;
import com.acme.fleetmanagement.service.ServiceRecordService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service-records")
public class ServiceRecordController {
    private final ServiceRecordService serviceRecordService;

    public ServiceRecordController(ServiceRecordService serviceRecordService) {
        this.serviceRecordService = serviceRecordService;
    }

    @GetMapping
    public String listServiceRecords(Model model) {
        List<ServiceRecord> serviceRecords = serviceRecordService.findAllServiceRecords();
        model.addAttribute("serviceRecords", serviceRecords);
        return "service-records/list";
    }

    @GetMapping("/new")
    public String showServiceRecordForm(Model model) {
        model.addAttribute("serviceRecord", new ServiceRecord());
        return "service-records/form";
    }

    @PostMapping
    public String saveServiceRecord(@ModelAttribute ServiceRecord serviceRecord) {
        serviceRecordService.saveServiceRecord(serviceRecord);
        return "redirect:/service-records";
    }

    @GetMapping("/{id}")
    public String showServiceRecord(@PathVariable UUID id, Model model) {
        ServiceRecord serviceRecord = serviceRecordService.findServiceRecordById(id);
        model.addAttribute("serviceRecord", serviceRecord);
        return "service-records/view";
    }

    @GetMapping("/{id}/edit")
    public String editServiceRecord(@PathVariable UUID id, Model model) {
        ServiceRecord serviceRecord = serviceRecordService.findServiceRecordById(id);
        model.addAttribute("serviceRecord", serviceRecord);
        return "service-records/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteServiceRecord(@PathVariable UUID id) {
        serviceRecordService.deleteServiceRecord(id);
        return "redirect:/service-records";
    }
}

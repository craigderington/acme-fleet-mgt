package com.acme.fleetmanagement.controller;

import com.acme.fleetmanagement.model.Vehicle;
import com.acme.fleetmanagement.service.VehicleService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String listVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicles/list";
    }

    @GetMapping("/new")
    public String showVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/form";
    }

    @PostMapping
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/{id}")
    public String showVehicle(@PathVariable UUID id, Model model) {
        Vehicle vehicle = vehicleService.findVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicles/view";
    }

    @GetMapping("/{id}/edit")
    public String editVehicle(@PathVariable UUID id, Model model) {
        Vehicle vehicle = vehicleService.findVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicles/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteVehicle(@PathVariable UUID id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
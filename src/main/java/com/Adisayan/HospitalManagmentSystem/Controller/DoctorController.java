package com.Adisayan.HospitalManagmentSystem.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @PostMapping("/doctor")
    public void createDoctor() {

    }

    @GetMapping("/doctor")
    public void getDoctors() {

    }

    @GetMapping("/doctor/{id}")
    public void getDoctorById(@PathVariable long id) {

    }

    @PutMapping("/doctor/{id}")
    public void updateDoctor(@PathVariable long id) {

    }

    @DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable long id) {

    }
}

package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import org.springframework.web.bind.annotation.*;

public class appointmentController {

    @PostMapping("/appointment")
    public void createAppointment(@RequestBody Appointment appointment) {

    }

    @GetMapping("/appointment")
    public void getAllAppointments() {

    }

    @GetMapping("/appointment/{id}")
    public void getAppointmentById(@PathVariable long id) {

    }

    @PutMapping("/appointment/{id}")
    public void updateAppointment(@PathVariable long id) {

    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable long id) {

    }
}

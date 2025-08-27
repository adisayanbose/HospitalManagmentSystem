package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.Service.PatientService;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/patient")
    void createPatient(@RequestBody Patient patient) {
        patientService.setPatient(patient);
    }

    @GetMapping("/patient")
    List<Patient> getAllPatients() {
        System.out.println("all patients endpoint");
        return new ArrayList<>();
    }

    @GetMapping("/patient/{id}")
    String viewPatient(@PathVariable Long id) {
        return "get end point for patient with id " + id;
    }

    @PutMapping("/patient/{id}")
    void EditPatient(@PathVariable Long id) {
        System.out.println("edit patient endpoint");
    }

    @DeleteMapping("/patient/{id}")
    void DeletePatient(@PathVariable Long id) {
        System.out.println("delete patient endpoint");
    }

}

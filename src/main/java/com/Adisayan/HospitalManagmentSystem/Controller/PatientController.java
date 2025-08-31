package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.DTO.ApiResponse;
import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientDto;
import com.Adisayan.HospitalManagmentSystem.Service.PatientService;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;

    @PostMapping("/patient")
    public ResponseEntity<ApiResponse> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(ApiResponse.success("Patient Created", createdPatient), HttpStatus.CREATED);
    }

    @GetMapping("/patient")
    public ResponseEntity<ApiResponse> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(ApiResponse.success("fetched all the patients", patients), HttpStatus.OK);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<ApiResponse<Patient>> viewPatient(@PathVariable Long id) {
        Patient patient = patientService.getPatient(id);
        return new ResponseEntity<>(ApiResponse.success("user fetched", patient), HttpStatus.OK);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<ApiResponse<Patient>> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        System.out.println(patientDto);
        Patient patient = patientService.updatePatient(patientDto, id);
        return new ResponseEntity<>(ApiResponse.success("updated Patient Successfully ", patient), HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<ApiResponse<?>> DeletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(ApiResponse.success("delted succesfully", null), HttpStatus.OK);
    }

}

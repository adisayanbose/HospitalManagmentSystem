package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.DTO.ApiResponse;
import com.Adisayan.HospitalManagmentSystem.DTO.Doctor.DoctorSummaryDto;
import com.Adisayan.HospitalManagmentSystem.Service.DoctorService;
import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import com.Adisayan.HospitalManagmentSystem.DTO.Doctor.DoctorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/doctor")
    public ResponseEntity<ApiResponse<Doctor>> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(ApiResponse.success("Doctor Created", createdDoctor), HttpStatus.CREATED);
    }

    @GetMapping("/doctor")
    public ResponseEntity<ApiResponse<List<DoctorSummaryDto>>> getDoctors() {
        List<DoctorSummaryDto> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(ApiResponse.success("fetched all doctors", doctors), HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<ApiResponse<Doctor>> getDoctorById(@PathVariable long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(ApiResponse.success("fetched doctor with id" + id, doctor), HttpStatus.OK);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<ApiResponse<Doctor>> updateDoctor(@PathVariable long id, @RequestBody DoctorDto doctorDto) {
        Doctor doctor = doctorService.updateDoctor(doctorDto, id);
        return new ResponseEntity<>(ApiResponse.success("Updated doctor succesfully", doctor), HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<ApiResponse<?>> deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(ApiResponse.success("Deleted the doctor with id" + id, null), HttpStatus.OK);
    }
}

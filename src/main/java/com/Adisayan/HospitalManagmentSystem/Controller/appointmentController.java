package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.DTO.ApiResponse;
import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.Service.AppointmentService;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class appointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<ApiResponse<AppointmentResponseDto>> createAppointment(@RequestBody Appointment appointment, @RequestParam Long id) {
        AppointmentResponseDto createdAppointment = appointmentService.createAppointment(appointment, id);
        return new ResponseEntity<>(ApiResponse.success("Appointment Genrated", createdAppointment), HttpStatus.CREATED);
    }

    @GetMapping("/appointment")
    public ResponseEntity<ApiResponse<Page<Appointment>>> getAllAppointments(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "1") int pageSize) {
        Page<Appointment> appointmentPage = appointmentService.getAppointments(pageNumber, pageSize);
        return new ResponseEntity<>(ApiResponse.success("Fetched appointments", appointmentPage), HttpStatus.OK);
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

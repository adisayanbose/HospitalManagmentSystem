package com.Adisayan.HospitalManagmentSystem.Controller;

import com.Adisayan.HospitalManagmentSystem.DTO.ApiResponse;
import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentRequestDTO;
import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.Service.AppointmentService;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class appointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/appointment/{patientId}")
    public ResponseEntity<ApiResponse<AppointmentResponseDto>> createAppointment(@RequestBody Appointment appointment, @PathVariable Long patientId, @RequestParam Long doctorId) {
        AppointmentResponseDto createdAppointment = appointmentService.createAppointment(appointment, patientId, doctorId);
        return new ResponseEntity<>(ApiResponse.success("Appointment Genrated", createdAppointment), HttpStatus.CREATED);
    }

    @GetMapping("/appointment")
    public ResponseEntity<ApiResponse<List<AppointmentResponseDto>>> getAllAppointments(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        List<AppointmentResponseDto> appointments = appointmentService.getAppointments(pageNumber, pageSize);
        return new ResponseEntity<>(ApiResponse.success("Fetched appointments", appointments), HttpStatus.OK);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<ApiResponse<AppointmentResponseDto>> getAppointmentById(@PathVariable long id) {
        AppointmentResponseDto appointment = appointmentService.getAppointment(id);
        return new ResponseEntity<>(ApiResponse.success("fetched appointment by Id", appointment), HttpStatus.OK);
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<ApiResponse<AppointmentResponseDto>> updateAppointment(@PathVariable long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDto appointment = appointmentService.updateAppointment(id, appointmentRequestDTO);
        return new ResponseEntity<>(ApiResponse.success("updated the Appointment with id " + id, appointment), HttpStatus.CREATED);
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(ApiResponse.success("deleter appointment with id " + id, null), HttpStatus.OK);
    }
}

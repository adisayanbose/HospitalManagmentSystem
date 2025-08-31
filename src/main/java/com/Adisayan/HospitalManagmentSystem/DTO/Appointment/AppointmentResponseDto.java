package com.Adisayan.HospitalManagmentSystem.DTO.Appointment;

import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponseDto {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;
    private PatientDto patient;
}

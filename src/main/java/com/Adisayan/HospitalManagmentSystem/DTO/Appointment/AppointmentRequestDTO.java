package com.Adisayan.HospitalManagmentSystem.DTO.Appointment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AppointmentRequestDTO {
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;
}

package com.Adisayan.HospitalManagmentSystem.DTO.Patient;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
public class PatientSummaryResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String email;
    private String bloodGroup;
    private LocalDateTime admittedAt;
    private List<Long> appointmentId;
}

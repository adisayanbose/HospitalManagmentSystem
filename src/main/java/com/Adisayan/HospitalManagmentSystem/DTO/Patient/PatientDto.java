package com.Adisayan.HospitalManagmentSystem.DTO.Patient;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PatientDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String email;
    private String bloodGroup;
    private LocalDateTime admittedAt;

}

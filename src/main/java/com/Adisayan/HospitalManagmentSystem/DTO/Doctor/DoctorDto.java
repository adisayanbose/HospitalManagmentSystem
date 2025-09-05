package com.Adisayan.HospitalManagmentSystem.DTO.Doctor;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class DoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private LocalDateTime JoiningDate;
}

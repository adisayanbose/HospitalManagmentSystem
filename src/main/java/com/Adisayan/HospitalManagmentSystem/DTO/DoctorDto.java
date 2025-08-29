package com.Adisayan.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDto {

    private Long id;
    private String name;
    private String specialization;
    private String email;
    private LocalDateTime JoiningDate;
}

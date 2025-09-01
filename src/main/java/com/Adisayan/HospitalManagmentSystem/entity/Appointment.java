package com.Adisayan.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Patient patient;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Doctor doctor;
}

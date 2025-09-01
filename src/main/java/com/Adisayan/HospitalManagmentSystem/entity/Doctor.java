package com.Adisayan.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String specialization;
    @Column(nullable = false, unique = true)
    private String email;
    @CreationTimestamp
    private LocalDateTime JoiningDate;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}

package com.Adisayan.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @OneToMany(mappedBy = "doctors")
    private List<Department> departments;
//    @OneToMany(mappedBy = "")
//    private List<Appointment> appointments;
}

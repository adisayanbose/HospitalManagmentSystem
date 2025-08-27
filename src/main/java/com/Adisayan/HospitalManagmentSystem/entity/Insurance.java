package com.Adisayan.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    private String provider;

    @Column(nullable = false)
    private LocalDate validUntil;
    private LocalDateTime generatedAt;

    @OneToOne(mappedBy = "insurance")
    private Patient patient;


}

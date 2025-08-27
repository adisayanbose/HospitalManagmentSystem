package com.Adisayan.HospitalManagmentSystem.repository;

import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
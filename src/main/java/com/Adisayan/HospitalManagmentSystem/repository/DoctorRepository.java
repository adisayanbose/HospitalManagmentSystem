package com.Adisayan.HospitalManagmentSystem.repository;

import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
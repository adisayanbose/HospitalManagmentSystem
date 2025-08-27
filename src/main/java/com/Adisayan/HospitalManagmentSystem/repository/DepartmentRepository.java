package com.Adisayan.HospitalManagmentSystem.repository;

import com.Adisayan.HospitalManagmentSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
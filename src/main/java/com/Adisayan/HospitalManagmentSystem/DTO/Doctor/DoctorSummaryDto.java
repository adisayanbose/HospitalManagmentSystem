package com.Adisayan.HospitalManagmentSystem.DTO.Doctor;

import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import com.Adisayan.HospitalManagmentSystem.entity.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class DoctorSummaryDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private LocalDateTime JoiningDate;
    private List<Long> appointmentId;

}

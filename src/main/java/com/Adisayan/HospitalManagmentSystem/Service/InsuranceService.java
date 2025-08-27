package com.Adisayan.HospitalManagmentSystem.Service;

import com.Adisayan.HospitalManagmentSystem.entity.Insurance;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import com.Adisayan.HospitalManagmentSystem.repository.InsuranceRepository;
import com.Adisayan.HospitalManagmentSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient not found exception"));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }
}

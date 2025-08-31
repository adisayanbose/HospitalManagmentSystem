package com.Adisayan.HospitalManagmentSystem.Service;

import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientDto;
import com.Adisayan.HospitalManagmentSystem.Mappers.PatientMapper;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import com.Adisayan.HospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public Patient addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).get();
    }

    @Transactional
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }

    public Patient updatePatient(PatientDto patientDto, Long id) {
        Patient existingPatient = patientRepository.findById(id).get();
        patientMapper.PatientDtoToPatient(patientDto, existingPatient);
        System.out.println(existingPatient);
        return patientRepository.save(existingPatient);
    }
}

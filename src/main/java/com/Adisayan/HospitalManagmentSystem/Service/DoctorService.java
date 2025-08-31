package com.Adisayan.HospitalManagmentSystem.Service;

import com.Adisayan.HospitalManagmentSystem.Mappers.DoctorMapper;
import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import com.Adisayan.HospitalManagmentSystem.DTO.Doctor.DoctorDto;
import com.Adisayan.HospitalManagmentSystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id) {
        return doctorRepository.findById(id).get();
    }

    public void deleteDoctor(long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }

    public Doctor updateDoctor(DoctorDto doctor, long id) {
        Doctor existingdoctor = doctorRepository.findById(id).get();
        doctorMapper.doctorDtoToDoctor(doctor, existingdoctor);
        System.out.println(existingdoctor);
        return doctorRepository.save(existingdoctor);
    }
}

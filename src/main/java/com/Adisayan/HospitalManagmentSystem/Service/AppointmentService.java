package com.Adisayan.HospitalManagmentSystem.Service;


import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentRequestDTO;
import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.Mappers.AppointmentMapper;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import com.Adisayan.HospitalManagmentSystem.repository.AppointmentRepository;
import com.Adisayan.HospitalManagmentSystem.repository.DoctorRepository;
import com.Adisayan.HospitalManagmentSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;
    private final DoctorRepository doctorRepository;

    public AppointmentResponseDto createAppointment(Appointment appointment, Long id, Long doctorId) {
        Patient patient = patientRepository.findById(id).get();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        Appointment createdAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toappointmentResponseDto(createdAppointment);
    }

    public List<AppointmentResponseDto> getAppointments(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Appointment> appointmentPage = appointmentRepository.findAll(pageable);
        return appointmentMapper.toAppointmentResponseDtoList(appointmentPage);
    }

    public AppointmentResponseDto getAppointment(long id) {
        Appointment appointment = appointmentRepository.findById(id).get();
        return appointmentMapper.toappointmentResponseDto(appointment);
    }

    public AppointmentResponseDto updateAppointment(long id, AppointmentRequestDTO appointmentRequestDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id).get();
        appointmentMapper.updateAppointment(appointmentRequestDTO, existingAppointment);
        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);
        return appointmentMapper.toappointmentResponseDto(updatedAppointment);
    }

    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);

    }
}

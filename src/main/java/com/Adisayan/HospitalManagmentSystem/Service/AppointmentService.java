package com.Adisayan.HospitalManagmentSystem.Service;


import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.Mappers.AppointmentMapper;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import com.Adisayan.HospitalManagmentSystem.repository.AppointmentRepository;
import com.Adisayan.HospitalManagmentSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentResponseDto createAppointment(Appointment appointment, Long id) {
        Patient patient = patientRepository.findById(id).get();
        appointment.setPatient(patient);
        Appointment createdAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toappointmentResponseDto(createdAppointment);
    }

    public Page<Appointment> getAppointments(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return appointmentRepository.findAll(pageable);
    }
}

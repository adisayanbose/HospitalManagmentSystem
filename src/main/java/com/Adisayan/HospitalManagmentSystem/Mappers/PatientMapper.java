package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientDetailResponseDto;
import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientRequestDto;
import com.Adisayan.HospitalManagmentSystem.DTO.Patient.PatientSummaryResponseDto;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientMapper {


    public Patient toPatient(PatientRequestDto patientRequestDto);

    public void updatePatient(PatientRequestDto patientRequestDto, @MappingTarget Patient entity);

    @Mapping(source = "appointments", target = "appointmentId")
    public PatientSummaryResponseDto toPatientDetailDto(Patient patient);

    public List<PatientSummaryResponseDto> toPatientDetailDtoList(List<Patient> patients);

    default Long map(Appointment appointment) {
        return appointment == null ? null : appointment.getId();
    }
}


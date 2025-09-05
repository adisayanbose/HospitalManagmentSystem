package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.DTO.Doctor.DoctorSummaryDto;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import com.Adisayan.HospitalManagmentSystem.DTO.Doctor.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorMapper {
    public void doctorDtoToDoctor(DoctorDto doctorDto, @MappingTarget Doctor entity);

    @Mapping(source = "appointments", target = "appointmentId")
    public DoctorSummaryDto toDoctorSummaryDto(Doctor doctor);

    public List<DoctorSummaryDto> toDoctorSummaryDtoList(List<Doctor> doctor);

    default Long map(Appointment appointment) {
        if (appointment == null) {
            return null;
        } else {
            return appointment.getId();
        }
    }
}

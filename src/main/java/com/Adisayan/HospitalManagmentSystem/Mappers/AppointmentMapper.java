package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppointmentMapper {

    public AppointmentResponseDto toappointmentResponseDto(Appointment createdAppointment);

}

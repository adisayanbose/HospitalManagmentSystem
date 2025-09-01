package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentRequestDTO;
import com.Adisayan.HospitalManagmentSystem.DTO.Appointment.AppointmentResponseDto;
import com.Adisayan.HospitalManagmentSystem.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppointmentMapper {

    public AppointmentResponseDto toappointmentResponseDto(Appointment createdAppointment);

    public List<AppointmentResponseDto> toAppointmentResponseDtoList(Page<Appointment> appointmentPage);

    public Appointment updateAppointment(AppointmentRequestDTO appointmentRequestDTO, @MappingTarget Appointment appointment);
}

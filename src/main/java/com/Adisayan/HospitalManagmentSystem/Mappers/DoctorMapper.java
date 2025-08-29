package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.entity.Doctor;
import com.Adisayan.HospitalManagmentSystem.entity.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorMapper {
    public Doctor doctorDtoToDoctor(DoctorDto doctorDto, @MappingTarget Doctor entity);
}

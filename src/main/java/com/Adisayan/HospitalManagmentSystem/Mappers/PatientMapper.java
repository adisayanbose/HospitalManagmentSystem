package com.Adisayan.HospitalManagmentSystem.Mappers;

import com.Adisayan.HospitalManagmentSystem.DTO.PatientDto;
import com.Adisayan.HospitalManagmentSystem.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientMapper {


    public Patient PatientDtoToPatient(PatientDto patientDto, @MappingTarget Patient entity);
}


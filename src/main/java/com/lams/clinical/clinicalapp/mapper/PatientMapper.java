package com.lams.clinical.clinicalapp.mapper;

import com.lams.clinical.clinicalapp.dto.PatientDto;
import com.lams.clinical.clinicalapp.entities.Patient;

public class PatientMapper {
	public static Patient toEntity(PatientDto patientDto) {
		return new Patient(patientDto.getId(), patientDto.getFirstName(), patientDto.getLastName(),
				patientDto.getBirthdate(), patientDto.getSex(), patientDto.getPhone(), patientDto.getAddress(),
				patientDto.getCity(), patientDto.getCountry(), patientDto.getDocType(), patientDto.getDocNumber(),
				patientDto.getEmail());

	}

	public static PatientDto toDto(Patient patient) {
		return new PatientDto(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getBirthdate(),
				patient.getSex(), patient.getPhone(), patient.getAddress(), patient.getCity(), patient.getCountry(),
				patient.getDocType(), patient.getDocNumber(), patient.getEmail());
	}
}

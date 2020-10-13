package com.lams.clinical.clinicalapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.lams.clinical.clinicalapp.dto.PatientDto;
import com.lams.clinical.clinicalapp.entities.Patient;
import com.lams.clinical.clinicalapp.exception.PatientIsNotRegisteredException;
import com.lams.clinical.clinicalapp.exception.ThepatientIsAlreadyRegistered;
import com.lams.clinical.clinicalapp.mapper.PatientMapper;
import com.lams.clinical.clinicalapp.repository.ClinicalRepository;

@Service
public class ClinicalService {

	@Autowired
	private MessageSource message;

	@Autowired
	private ClinicalRepository repository;

	public List<PatientDto> findAll() {
		List<Patient> patientsList = repository.findAll();
		List<PatientDto> patientsDtoList = new ArrayList<PatientDto>();

		for (Patient patient : patientsList) {

			patientsDtoList.add(PatientMapper.toDto(patient));

		}

		return patientsDtoList;
	}

	public PatientDto save(PatientDto patientDto) {
		Optional<Patient> patientOpt = repository.findOneByDocTypeAndDocNumber(patientDto.getDocNumber(),
				patientDto.getDocType());

		if (patientOpt.isPresent()) {
			throw new ThepatientIsAlreadyRegistered(message.getMessage("error.clinical.patient.create.already.exits",
					new Object[] { patientDto.getDocType(), patientDto.getDocNumber() },
					LocaleContextHolder.getLocale()));
		}
		Patient patient = new Patient(patientDto.getId(), patientDto.getFirstName(), patientDto.getLastName(),
				patientDto.getBirthdate(), patientDto.getSex(), patientDto.getPhone(), patientDto.getAddress(),
				patientDto.getCity(), patientDto.getCountry(), patientDto.getDocType(), patientDto.getDocNumber(),
				patientDto.getEmail());

		repository.save(patient);

		return PatientMapper.toDto(patient);
	}


	public PatientDto getId(Integer id) {
		Optional<Patient> patientOpt = repository.findById(id);

		if (!patientOpt.isPresent()) {
			throw new PatientIsNotRegisteredException(message.getMessage("error.clinical.patient.get.is.not.registry",
					new Integer[] { id }, LocaleContextHolder.getLocale()));
		}
		PatientDto patientDto = PatientMapper.toDto(patientOpt.get());

		return patientDto;
	}

	public PatientDto setPatient(Integer id, PatientDto patientDtoIn) {
		Optional<Patient> patientOpt = repository.findById(id);

		if (!patientOpt.isPresent()) {
			throw new PatientIsNotRegisteredException(message.getMessage("error.clinical.patient.set.is.not.registry",
					new Integer[] { id }, LocaleContextHolder.getLocale()));
		}
		PatientDto patientDto = PatientMapper.toDto(patientOpt.get());
		patientDto.setFirstName(patientDtoIn.getFirstName());
		patientDto.setLastName(patientDtoIn.getLastName());
		patientDto.setBirthdate(patientDtoIn.getBirthdate());
		patientDto.setSex(patientDtoIn.getSex());
		patientDto.setPhone(patientDtoIn.getPhone());
		patientDto.setAddress(patientDtoIn.getAddress());
		patientDto.setCity(patientDtoIn.getCity());
		patientDto.setCountry(patientDtoIn.getCountry());
		patientDto.setDocType(patientDtoIn.getDocType());
		patientDto.setDocNumber(patientDtoIn.getDocNumber());
		patientDto.setEmail(patientDtoIn.getEmail());

		repository.save(PatientMapper.toEntity(patientDto));

		return patientDto;
	}

	public void deletePatient(Integer id) {
		Optional<Patient> patientOpt = repository.findById(id);

		if (!patientOpt.isPresent()) {
			throw new PatientIsNotRegisteredException(
					message.getMessage("error.clinical.patient.delete.is.not.registry", new Integer[] { id },
							LocaleContextHolder.getLocale()));
		} else {
			repository.deleteById(id);
		}
	}
}

package com.lams.clinical.clinicalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lams.clinical.clinicalapp.dto.PatientDto;
import com.lams.clinical.clinicalapp.service.ClinicalService;

@RestController
public class ClinicalController {

	@Autowired
	private ClinicalService service;

	@Autowired
	private MessageSource message;
	Logger logger = LoggerFactory.getLogger(ClinicalController.class);

	@GetMapping("/clinical")
	public List<PatientDto> retriveAllUsers() {
		logger.info(message.getMessage("info.clinical.patient.retrieveAllPatients.info", null,
				LocaleContextHolder.getLocale()));
		List<PatientDto> patientDto = service.findAll();
		return patientDto;

	}

	@PostMapping("/clinical")
	public ResponseEntity<PatientDto> createRegistry(@Valid @RequestBody PatientDto patientDto) {
		logger.info(
				message.getMessage("info.clinical.patient.createPatient.info", null, LocaleContextHolder.getLocale()));

		patientDto = service.save(patientDto);

		return new ResponseEntity<PatientDto>(patientDto, HttpStatus.CREATED);
	}

	@GetMapping("/clinical/{id}")
	public PatientDto getPatient(@PathVariable Integer id) {
		logger.info(
				message.getMessage("info.clinical.patient.getpatientId.info", null, LocaleContextHolder.getLocale()));
		PatientDto patientDto = service.getId(id);
		return patientDto;

	}

	@PutMapping("/clinical/{id}")
	public PatientDto setPatient(@RequestBody PatientDto patientDtoIn, @PathVariable Integer id) {
		logger.info(
				message.getMessage("info.clinical.patient.setPatientId.info", null, LocaleContextHolder.getLocale()));
		PatientDto patientDto = service.setPatient(id, patientDtoIn);
		return patientDto;
	}
	
	@DeleteMapping("/clinical/{id}")
	public void deletePatient(@PathVariable Integer id) {
		logger.info(
				message.getMessage("info.clinical.patient.DeletePatientId.info", null, LocaleContextHolder.getLocale()));
		service.deletePatient(id);
	}

}
package com.lams.clinical.clinicalapp.exception;

public class PatientIsNotRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientIsNotRegisteredException(String message) {
		super(message);
	}
}

package com.lams.clinical.clinicalapp.exception;

public class ThepatientIsAlreadyRegistered extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThepatientIsAlreadyRegistered(String message) {
		super(message);
	}
}

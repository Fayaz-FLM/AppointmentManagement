package com.flm.appointment.exception;

public class AppointmentAlreadyExistsException extends RuntimeException{
	
	public AppointmentAlreadyExistsException (String message) {
		super(message);
	}

}

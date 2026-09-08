package com.flm.appointment.exceptions;

public class AppointmentAlreadyExistsException extends RuntimeException{
	
	public AppointmentAlreadyExistsException (String message) {
		super(message);
	}

}

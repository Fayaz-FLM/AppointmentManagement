package com.flm.appointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException appointmentNotFoundException) {
		return new ResponseEntity<>(appointmentNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppointmentAlreadyExistsException.class)
	public ResponseEntity<String> handleAppointmentAlreadyExistsException(AppointmentAlreadyExistsException appointmentAlreadyExistsException) {
		return new ResponseEntity<>(appointmentAlreadyExistsException.getMessage(),HttpStatus.CONFLICT);
	}
}

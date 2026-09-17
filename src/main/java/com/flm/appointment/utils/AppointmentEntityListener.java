package com.flm.appointment.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.appointment.enums.AppointmentStatus;
import com.flm.appointment.model.Appointment;

import jakarta.persistence.PrePersist;

@Component
public class AppointmentEntityListener {

	public static AppointmentIdGenerator appointmentIdGenerator;
	
	@Autowired
	public void init(AppointmentIdGenerator appointmentIdGenerator) {
		this.appointmentIdGenerator = appointmentIdGenerator;
	}
	
	@PrePersist
	public void generateAppointmentId(Appointment appointment) {
		if(appointment.getId() == null) {
			appointment.setId(appointmentIdGenerator.generateNextAppointmentId());
			if(appointment.getAppointmentStatus() == null){
				appointment.setAppointmentStatus(appointment.getAppointmentStatus().SCHEDULED);				
			}
		}
	}
	
}

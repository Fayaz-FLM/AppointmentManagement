package com.flm.appointment.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.flm.appointment.dao.AppointmentRepository;

@Component
public class AppointmentIdGenerator {

	private final AppointmentRepository appointmentRepository;
	
	public AppointmentIdGenerator(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	public Long generateNextAppointmentId() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String formattedCurrentDateTime = currentDateTime.format(dateTimeFormatter);
		String lastAppointmentId = appointmentRepository.findLastAppointmentId(formattedCurrentDateTime);
		
		int nextNumber = 1;
		String appointmentIdSuffix = "";
		String appointmentId = "";
		
		if(lastAppointmentId != null && lastAppointmentId.startsWith(formattedCurrentDateTime)) {
			String idSuffix = lastAppointmentId.substring(14);
			nextNumber = Integer.parseInt(idSuffix) + 1;
			appointmentIdSuffix = String.format("%05d",nextNumber);
			appointmentId = formattedCurrentDateTime + appointmentIdSuffix;
			return Long.parseLong(appointmentId);
		}
		else {
			appointmentIdSuffix = String.format("%05d",nextNumber);
			appointmentId = formattedCurrentDateTime + appointmentIdSuffix;
			return Long.parseLong(appointmentId);
		}
	}
}

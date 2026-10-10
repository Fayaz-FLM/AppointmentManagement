package com.flm.appointment.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flm.appointment.dao.AppointmentRepository;
import com.flm.appointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private final AppointmentRepository appointmentRepository;
	
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		this.appointmentRepository=appointmentRepository;
	}

	@Override
	public List<Long> getPatientsByDoctorIdInDateRange(Long doctorId,LocalDate startDate,LocalDate endDate) {
		return appointmentRepository.findPatientsByDoctorIdInDateRange(doctorId, startDate, endDate);
	}

}

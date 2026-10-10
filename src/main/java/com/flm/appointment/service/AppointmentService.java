package com.flm.appointment.service;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentService {

	public List<Long> getPatientsByDoctorIdInDateRange(Long doctorId,LocalDate startDate,LocalDate endDate);
}

package com.flm.appointment.builder;

import com.flm.appointment.dto.AppointmentResponseDTO;
import com.flm.appointment.model.Appointment;

public class AppointmentDTOBuilder {

	static public AppointmentResponseDTO buildAppointmentResponseDTO(Appointment appointment, String diagnosis) {
		
		return AppointmentResponseDTO.builder()
							.appointmentId(String.valueOf(appointment.getId()))
							.patientId(String.valueOf(appointment.getPatientId()))
							.doctorId(String.valueOf(appointment.getDoctorId()))
							.appointmentDate(appointment.getAppointmentDate())
							.startTime(appointment.getStartTime())
							.endTime(appointment.getEndTime())
							.status(String.valueOf(appointment.getAppointmentStatus()))
							.notes(appointment.getNotes())
							.diagnosisSummary(diagnosis)
							.build();
							
	}
	
	static public AppointmentResponseDTO buildAppointmentResponseDTO(Appointment appointment) {
		
		return buildAppointmentResponseDTO(appointment, null);
	}
}

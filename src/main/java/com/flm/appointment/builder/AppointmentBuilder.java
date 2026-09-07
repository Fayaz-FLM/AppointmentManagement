package com.flm.appointment.builder;

import com.flm.appointment.dto.request.AppointmentRequestDTO;
import com.flm.appointment.enums.AppointmentStatus;
import com.flm.appointment.model.Appointment;

public class AppointmentBuilder {

	public static Appointment buildAppointmentFromAppointmentRequestDTO(AppointmentRequestDTO appointmentRequestDTO) {
		return Appointment.builder()
				.patientId(Long.parseLong(appointmentRequestDTO.getPatientId()))
				.doctorId(Long.parseLong(appointmentRequestDTO.getDoctorId()))
				.appointmentDate(appointmentRequestDTO.getAppointmentDate())
				.startTime(appointmentRequestDTO.getStartTime())
				.endTime(appointmentRequestDTO.getEndTime())
				.notes(appointmentRequestDTO.getNotes())
				.appointmentStatus(AppointmentStatus.SCHEDULED)
				.build();
	}
}

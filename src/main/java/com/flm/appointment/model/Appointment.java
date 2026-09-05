package com.flm.appointment.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.flm.appointment.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="patient_id", nullable = false)
	private Long patientId;
	
	@Column(name="doctor_id", nullable = false)
	private Long doctorId;
	
	@Column(name="appointment_date", nullable = false)
	private LocalDate appointmentDate;
	
	@Column(name="start_time", nullable = false)
	private LocalTime startTime;
	
	@Column(name="end_time", nullable = false)
	private LocalTime endTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="appointment_status", nullable=false)
	private AppointmentStatus appointmentStatus;
	
	@Column(name="notes")
	private String notes;
	
	// constructor without id to create objects without id because using @Generated Values
	public Appointment(Long patientId, Long doctorId, LocalDate appointmentDate, LocalTime startTime, LocalTime endTime,
			AppointmentStatus appointmentStatus, String notes) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.appointmentStatus = appointmentStatus;
		this.notes = notes;
	}
	
}

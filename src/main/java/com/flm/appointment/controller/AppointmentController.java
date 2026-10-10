package com.flm.appointment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flm.appointment.service.AppointmentService;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService=appointmentService;
	}
	
	@GetMapping("/getPatientsByDoctorId/{staffId}")
    public List<Long> getPatientsByDoctorIdInDateRange(@PathVariable(name="staffId") Long doctorId,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate){
    	return appointmentService.getPatientsByDoctorIdInDateRange(doctorId, startDate, endDate);
    }
}

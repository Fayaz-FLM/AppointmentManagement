package com.flm.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.flm.appointment.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	@Query(value = "select appointment_id from appointments where appointment_id like concat(?1,'%') order by appointment_id desc limit 1",nativeQuery = true)
	String findLastAppointmentId(String dateTimeSequence);
	
}

package com.flm.appointment.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flm.appointment.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	@Query(value = "select appointment_id from appointments where appointment_id like concat(?1,'%') order by appointment_id desc limit 1",nativeQuery = true)
	String findLastAppointmentId(String dateTimeSequence);
	
	@Query(value = "select distinct patient_id from appointments where doctor_id=?1 and appointment_date between ?2 and ?3",nativeQuery = true )
	List<Long> findPatientsByDoctorIdInDateRange(Long doctorId,LocalDate startDate,LocalDate endDate);
	
}

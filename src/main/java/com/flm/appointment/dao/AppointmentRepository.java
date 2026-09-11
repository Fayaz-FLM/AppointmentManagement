
package com.flm.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.appointment.model.Appointment;
@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

}
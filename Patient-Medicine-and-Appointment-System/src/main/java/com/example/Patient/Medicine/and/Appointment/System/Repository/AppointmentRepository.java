package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}

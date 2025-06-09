package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

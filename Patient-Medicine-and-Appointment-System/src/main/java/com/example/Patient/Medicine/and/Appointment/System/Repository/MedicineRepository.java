package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}

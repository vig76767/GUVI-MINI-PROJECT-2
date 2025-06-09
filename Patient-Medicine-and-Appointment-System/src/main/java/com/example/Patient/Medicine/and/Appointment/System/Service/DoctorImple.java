package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;

import java.util.List;

public interface DoctorImple {

    Doctor save(Doctor doctor);
    List<Doctor> viewAll();
}

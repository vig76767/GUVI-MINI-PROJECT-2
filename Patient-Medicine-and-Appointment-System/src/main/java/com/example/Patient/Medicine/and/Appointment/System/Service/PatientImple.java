package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;

import java.util.List;

public interface PatientImple {

    Patient Signup(Patient patient);
    List<Patient> viewAll();
}

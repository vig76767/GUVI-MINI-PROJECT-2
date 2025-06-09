package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientImple {

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient Signup(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public List<Patient> viewAll() {
        return patientRepository.findAll();
    }


}

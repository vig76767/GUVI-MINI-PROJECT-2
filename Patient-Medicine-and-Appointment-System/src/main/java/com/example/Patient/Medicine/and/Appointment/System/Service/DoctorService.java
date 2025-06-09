package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorImple{

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor save(Doctor doctor) {
        doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public List<Doctor> viewAll() {
        return doctorRepository.findAll();
    }
}

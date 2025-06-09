package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import com.example.Patient.Medicine.and.Appointment.System.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements Appointmentimple{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment adddetails(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> viewAll() {
        return appointmentRepository.findAll();
    }
}

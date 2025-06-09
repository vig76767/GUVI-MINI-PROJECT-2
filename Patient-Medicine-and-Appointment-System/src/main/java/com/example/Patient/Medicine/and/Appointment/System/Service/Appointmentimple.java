package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;

import java.util.List;

public interface Appointmentimple {
    Appointment adddetails(Appointment appointment);
    List<Appointment> viewAll();
}

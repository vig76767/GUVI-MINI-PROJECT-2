package com.example.Patient.Medicine.and.Appointment.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "Appointment_details_db")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AppointmentId;
    @Column(name = "PatientId")
    private Long PatientId;
    @Column(name = "DoctorId")
    private Long DoctorId;
    @Column(name = "AppointmentDate")
    private LocalDate AppointmentDate;
    @Column(name = "AppointmentStartingTime")
    private LocalTime AppointmentStartingTime;

}

package com.example.Patient.Medicine.and.Appointment.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="doctor_name")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DoctorId;
    @Column(name = "dFirstName", nullable = false)
    private String doctorFristName;
    @Column(name = "dLastName", nullable = false)
    private String doctorLastName;
    @Column(name = "dAge", nullable = false)
    private int doctorAge;
    @Column(name = "dEmail", nullable = false)
    private String doctorEmail;
    @Column(name = "dPassword", nullable = false)
    private String doctorPassword;
}

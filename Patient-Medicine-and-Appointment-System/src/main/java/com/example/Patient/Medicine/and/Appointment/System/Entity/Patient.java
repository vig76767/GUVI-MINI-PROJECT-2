package com.example.Patient.Medicine.and.Appointment.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PATIENT_DB")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Long patientId;
    @Column(name = "P_FIRST_NAME", nullable = false)
    private String patientFristName;
    @Column(name = "P_LAST_NAME", nullable = false)
    private String patientLastName;
    @Column(name = "P_AGE", nullable = false)
    private int patientAge;
    @Column(name = "P_EMAIL", nullable = false)
    private String patientEmail;
    @Column(name = "P_PASSWORD", nullable = false)
    private String patientPassword;
}

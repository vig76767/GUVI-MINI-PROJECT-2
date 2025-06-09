package com.example.Patient.Medicine.and.Appointment.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "medicine_details")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MedicineId;
    @Column(name = "PatientId")
    private Long PatientId;
    @Column(name = "DoctorId")
    private Long DoctorId;
    @Column(name = "medicinedetails")
    private String medicinedetails;
}

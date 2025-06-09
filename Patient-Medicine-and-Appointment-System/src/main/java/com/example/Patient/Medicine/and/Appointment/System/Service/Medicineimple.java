package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;

import java.util.List;

public interface Medicineimple {
    Medicine addMedicine(Medicine medicine);
    Medicine update(Medicine medicine);
    List<Medicine> viewall();
    void delete(Long id);
}

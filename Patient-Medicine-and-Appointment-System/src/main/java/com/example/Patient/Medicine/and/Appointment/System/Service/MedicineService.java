package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import com.example.Patient.Medicine.and.Appointment.System.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService implements Medicineimple{
    @Autowired
    private MedicineRepository medicineRepository;
    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine update(Medicine medicine) {
        Medicine medicine1 = new Medicine();
        medicine1.setMedicineId(medicine.getMedicineId());
        medicine1.setPatientId(medicine.getPatientId());
        medicine1.setDoctorId(medicine.getDoctorId());
        medicine1.setMedicinedetails(medicine.getMedicinedetails());
        return medicineRepository.save(medicine1);
    }

    @Override
    public List<Medicine> viewall() {
        return medicineRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        medicineRepository.deleteById(id);
    }
}

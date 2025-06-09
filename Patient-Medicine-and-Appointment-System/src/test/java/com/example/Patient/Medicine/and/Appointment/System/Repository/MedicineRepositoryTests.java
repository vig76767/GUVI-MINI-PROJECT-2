package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MedicineRepositoryTests {
    @Autowired
    private MedicineRepository medicineRepository;

@Test
public void givenMedicine_whensave_thenReturnsavemedince() {
    Medicine medicine = new Medicine();
    medicine.setPatientId(1l);
    medicine.setDoctorId(1l);
    medicine.setMedicinedetails("sdfsdfsdf");

    Medicine medicine1 = medicineRepository.save(medicine);
    assertThat(medicine1).isNotNull();
    assertThat(medicine1.getDoctorId()).isGreaterThan(0);
}

    @Test
    public void givenMedicine_whenviewAll_thenReturnviewAllmedicine() {
        Medicine medicine = new Medicine();
        medicine.setPatientId(1l);
        medicine.setDoctorId(1l);
        medicine.setMedicinedetails("sdfsdfsdf");

        Medicine medicine1 = medicineRepository.save(medicine);

        List<Medicine> medicines = medicineRepository.findAll();
        assertThat(medicines).isNotNull();
        assertThat(medicines.size()).isEqualTo(1);

    }

    @Test
    public void givenMedicine_whenupdate_thenReturnupdatemedicine() {
        Medicine medicine = new Medicine();
        medicine.setPatientId(1l);
        medicine.setDoctorId(1l);
        medicine.setMedicinedetails("sdfsdfsdf");

        Medicine medicine1 = medicineRepository.save(medicine);

        Medicine medicine2 =medicineRepository.findById(medicine.getMedicineId()).get();

        medicine2.setMedicinedetails("vignesh");
        Medicine medicine3 = medicineRepository.save(medicine);

        assertThat(medicine3.getMedicinedetails()).isEqualTo("vignesh");

    }
}

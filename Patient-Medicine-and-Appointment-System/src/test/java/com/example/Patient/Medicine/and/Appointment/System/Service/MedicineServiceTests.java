package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import com.example.Patient.Medicine.and.Appointment.System.Repository.MedicineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicineServiceTests {
    @Mock
    private MedicineRepository medicineRepository;
    @InjectMocks
    private MedicineService medicineService;
    @Test
    public void givenMedicine_whensave_thenReturnsavemedince() {
        Medicine medicine = new Medicine();
        medicine.setPatientId(1l);
        medicine.setDoctorId(1l);
        medicine.setMedicinedetails("sdfsdfsdf");

        given(medicineService.addMedicine(medicine)).willReturn(medicine);

        Medicine medicine1 = medicineRepository.save(medicine);
        assertThat(medicine1).isNotNull();
    }
    @Test
    public void givenMedicine_whenviewAll_thenReturnviewAllmedicine() {
        Medicine medicine = new Medicine();
        medicine.setPatientId(1l);
        medicine.setDoctorId(1l);
        medicine.setMedicinedetails("sdfsdfsdf");

        given(medicineRepository.findAll()).willReturn(List.of(medicine));

        List<Medicine> medicines = medicineService.viewall();

        assertThat(medicines).isNotNull();
        assertThat(medicines.size()).isEqualTo(1);

    }
    @Test
    public void deletebyId(){
        Medicine medicine = new Medicine();
        medicine.setPatientId(1l);
        medicine.setDoctorId(1l);
        medicine.setMedicinedetails("sdfsdfsdf");

        willDoNothing().given(medicineRepository).deleteById(medicine.getMedicineId());

        medicineService.delete(medicine.getMedicineId());

        verify(medicineRepository,times(1)).deleteById(medicine.getMedicineId());
    }

}

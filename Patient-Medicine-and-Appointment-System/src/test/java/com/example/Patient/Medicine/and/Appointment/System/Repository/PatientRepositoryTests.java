package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PatientRepositoryTests {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void givenPatient_whensave_thenReturnsavePatient(){
        Patient patient = new Patient();
        patient.setPatientFristName("vignesh");
        patient.setPatientLastName("R");
        patient.setPatientAge(25);
        patient.setPatientEmail("vignesh@gmail.com");
        patient.setPatientPassword("12345678");

        Patient patient1 = patientRepository.save(patient);

        assertThat(patient1).isNotNull();
        assertThat(patient1.getPatientId()).isGreaterThan(0);
    }
    @Test
    public void givenPatient_whensave_thenReturnviewAllPatient(){
        Patient patient = new Patient();
        patient.setPatientFristName("vignesh");
        patient.setPatientLastName("R");
        patient.setPatientAge(25);
        patient.setPatientEmail("vignesh@gmail.com");
        patient.setPatientPassword("12345678");

        Patient patient1 = patientRepository.save(patient);

        List<Patient> patientList = patientRepository.findAll();

        assertThat(patientList).isNotNull();
        assertThat(patientList.size()).isEqualTo(1);
    }


}

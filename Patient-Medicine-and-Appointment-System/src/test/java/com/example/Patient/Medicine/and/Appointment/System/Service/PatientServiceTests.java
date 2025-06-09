package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class PatientServiceTests {
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;

    @Test
    public void givenPatient_whensave_thenReturnsavePatient(){
        Patient patient = new Patient();
        patient.setPatientFristName("vignesh");
        patient.setPatientLastName("R");
        patient.setPatientAge(25);
        patient.setPatientEmail("vignesh@gmail.com");
        patient.setPatientPassword("12345678");
        given(patientRepository.save(patient)).willReturn(patient);

        Patient patient1 = patientService.Signup(patient);

        assertThat(patient1).isNotNull();

    }

    @Test
    public void givenPatient_whensave_thenReturnviewAllPatient(){
        Patient patient = new Patient();
        patient.setPatientFristName("vignesh");
        patient.setPatientLastName("R");
        patient.setPatientAge(25);
        patient.setPatientEmail("vignesh@gmail.com");
        patient.setPatientPassword("12345678");

        given(patientRepository.findAll()).willReturn(List.of(patient));

        List<Patient> patientList = patientService.viewAll();

        assertThat(patientList).isNotNull();
        assertThat(patientList.size()).isEqualTo(1);
    }
}

package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTests {
    @Mock
    private DoctorRepository doctorRepository;
    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void givenDoctor_whensave_thenReturnsaveDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorFristName("vignesf");
        doctor.setDoctorLastName("r");
        doctor.setDoctorAge(2);
        doctor.setDoctorEmail("vignesh@gmail.com");
        doctor.setDoctorPassword("12345678");

        given(doctorService.save(doctor)).willReturn(doctor);

        Doctor doctor1 = doctorRepository.save(doctor);

        assertThat(doctor1).isNotNull();

    }
    @Test
    public void givenDoctor_whenviewAll_thenReturnviewAllDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorFristName("vignes");
        doctor.setDoctorLastName("r");
        doctor.setDoctorAge(2);
        doctor.setDoctorEmail("vignesh@gmail.com");
        doctor.setDoctorPassword("12345678");

        given(doctorRepository.findAll()).willReturn(List.of(doctor));

        List<Doctor> doctorList = doctorService.viewAll();
        assertThat(doctorList).isNotNull();
        assertThat(doctorList.size()).isEqualTo(1);
    }
}

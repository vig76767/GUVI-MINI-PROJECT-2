package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DoctorRepositoryTests {
    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void givenDoctor_whensave_thenReturnsaveDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorFristName("vignesf");
        doctor.setDoctorLastName("r");
        doctor.setDoctorAge(2);
        doctor.setDoctorEmail("vignesh@gmail.com");
        doctor.setDoctorPassword("12345678");

        Doctor doctor1 = doctorRepository.save(doctor);

        assertThat(doctor1).isNotNull();
        assertThat(doctor1.getDoctorId()).isGreaterThan(0);
    }

    @Test
    public void givenDoctor_whenviewAll_thenReturnviewAllDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorFristName("vignesf");
        doctor.setDoctorLastName("r");
        doctor.setDoctorAge(2);
        doctor.setDoctorEmail("vignesh@gmail.com");
        doctor.setDoctorPassword("12345678");

        Doctor doctor1 = doctorRepository.save(doctor);

        List<Doctor> doctorList = doctorRepository.findAll();

        assertThat(doctorList).isNotNull();
        assertThat(doctorList.size()).isEqualTo(1);
    }
}

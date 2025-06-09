package com.example.Patient.Medicine.and.Appointment.System.Repository;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AppointmentRepositoryTests {

    @Autowired
    private  AppointmentRepository appointmentRepository;

    @Test
    public void givenAppointment_whensave_thenReturnsaveAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatientId(1l);
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setDoctorId(1l);
        appointment.setAppointmentStartingTime(LocalTime.now());

        Appointment appointment1 = appointmentRepository.save(appointment);

        assertThat(appointment1).isNotNull();
        assertThat(appointment1.getDoctorId()).isGreaterThan(0);
    }

    @Test
    public void givenAppointment_whenviewAll_thenReturnviewAllAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatientId(1l);
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setDoctorId(1l);
        appointment.setAppointmentStartingTime(LocalTime.now());

        Appointment appointment1 = appointmentRepository.save(appointment);

        List<Appointment> appointments = appointmentRepository.findAll();

        assertThat(appointments).isNotNull();
        assertThat(appointments.size()).isEqualTo(1);

    }
}

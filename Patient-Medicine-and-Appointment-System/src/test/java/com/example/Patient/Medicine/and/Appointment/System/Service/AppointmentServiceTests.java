package com.example.Patient.Medicine.and.Appointment.System.Service;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import com.example.Patient.Medicine.and.Appointment.System.Repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTests {
    @Mock
    private AppointmentRepository appointmentRepository;
    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void givenAppointment_whensave_thenReturnsaveAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatientId(1l);
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setDoctorId(1l);
        appointment.setAppointmentStartingTime(LocalTime.now());

        given(appointmentService.adddetails(appointment)).willReturn(appointment);

        Appointment appointment1 = appointmentRepository.save(appointment);

        assertThat(appointment1).isNotNull();

    }
    @Test
    public void givenAppointment_whenviewAll_thenReturnviewAllAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatientId(1l);
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setDoctorId(1l);
        appointment.setAppointmentStartingTime(LocalTime.now());

        given(appointmentRepository.findAll()).willReturn(List.of(appointment));

        List<Appointment> appointments = appointmentService.viewAll();

        assertThat(appointments).isNotNull();
        assertThat(appointments.size()).isEqualTo(1);

    }
}

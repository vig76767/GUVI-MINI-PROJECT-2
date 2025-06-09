package com.example.Patient.Medicine.and.Appointment.System.Controller;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class PatientControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private PatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void givenEmployee_whenSave_thenReturnSavedEmployee() throws Exception {
        Patient patient = new Patient();
        patient.setPatientFristName("vignesh");
        patient.setPatientLastName("R");
        patient.setPatientAge(25);
        patient.setPatientEmail("vignesh@gmail.com");
        patient.setPatientPassword("12345678");

        ResultActions response = mockMvc.perform(post("/api/employees")
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(patient)));

        response.andDo(print())
                .andExpect(jsonPath("$.firstName", is(patient.getPatientFristName())))
                .andExpect(jsonPath("$.lastName", is(patient.getPatientLastName())));
    }


}

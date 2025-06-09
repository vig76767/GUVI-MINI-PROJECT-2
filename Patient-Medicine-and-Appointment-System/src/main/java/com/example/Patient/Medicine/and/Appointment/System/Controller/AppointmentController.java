package com.example.Patient.Medicine.and.Appointment.System.Controller;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Service.AppointmentService;
import com.example.Patient.Medicine.and.Appointment.System.Service.DoctorService;
import com.example.Patient.Medicine.and.Appointment.System.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/addAppoinment")
    public String appointmentSlot(Model model){
        model.addAttribute("appointment", new Appointment());
        return "AddAppointment";
    }

    @PostMapping("/add/appointment/details")
    public String appointmentdetails(@Valid  @ModelAttribute Appointment appointment, BindingResult result, Model model){
        List<Patient> patientList = patientService.viewAll();
        List<Doctor> doctorList = doctorService.viewAll();
        Long pid = appointment.getPatientId();
        Long did = appointment.getDoctorId();

        boolean pcheck = false;
        for(Patient patient: patientList){
            if(pid == patient.getPatientId()){
                    pcheck= true;
            }
        }
        if(!pcheck){
            result.rejectValue("PatientId",null,"Invaild PatientId");
        }

        boolean dcheck= false;
        for(Doctor doctor :doctorList){
            if(did==doctor.getDoctorId()){
               dcheck= true;
            }
        }
        if(!dcheck){
            result.rejectValue("DoctorId",null,"Invaild DoctorId");
        }

        if(result.hasErrors()){
            model.addAttribute("appointment",appointment);
            return "AddAppointment";
        }
        appointmentService.adddetails(appointment);
        return "redirect:/addAppoinment?success";
    }
}

package com.example.Patient.Medicine.and.Appointment.System.Controller;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Repository.DoctorRepository;
import com.example.Patient.Medicine.and.Appointment.System.Service.MedicineService;
import com.example.Patient.Medicine.and.Appointment.System.Service.PatientService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
            private MedicineService medicineService;

    Long id =null;

    @GetMapping("/Patient/Login")
    public String MainPage(Model model){
        model.addAttribute("patient",new Patient());
        return "PatientLogin";
    }
    @PostMapping("/Patient/check")
    public String checkDetails(@ModelAttribute Patient patient){
        List<Patient> patientList = patientService.viewAll();
        for(Patient plist : patientList){
            if(patient.getPatientEmail().equals(plist.getPatientEmail())){
                if(patient.getPatientPassword().equals(plist.getPatientPassword())){
                    id=plist.getPatientId();
                    return "Mainpage";
                }
            }
        }
        return "redirect:/Patient/Login?failed";
    }

    @GetMapping("/patient/profile")
    public String profilr(Model modal){
        List<Patient> patientList = patientService.viewAll();
        for(Patient patient: patientList){
            if (patient.getPatientId()==id) {
                modal.addAttribute("patient",patient);
                break;
            }
        }
        return "Patientprofile";

    }

    @GetMapping("/Patient/SignUp")
    public String Signup(Model model){
        model.addAttribute("patient",new Patient());
        return "PatientSignUp";
    }
    @PostMapping("/Patient/confirm")
    public String signupconfirm(@Valid @ModelAttribute Patient patient ,BindingResult result ,Model model){
        List<Patient> patientList = patientService.viewAll();
        if(!patientList.isEmpty()) {
            String pfirstname = patient.getPatientFristName();
            String plastname  =patient.getPatientLastName();
            String pemail = patient.getPatientEmail();
            String password = patient.getPatientPassword();
            for (Patient patient1 : patientList) {
                for(int i=0;i<pfirstname.length();i++){
                    if(!(pfirstname.charAt(i)>='a' && pfirstname.charAt(i)<='z' || pfirstname.charAt(i)>='A' && pfirstname.charAt(i)<='Z')){
                        result.rejectValue("PatientFristName",null,"Only letters are allowed");
                        break;
                    }
                }

                for(int i=0;i<plastname .length();i++){
                    if(!(plastname.charAt(i)>='a' && plastname.charAt(i)<='z' || plastname.charAt(i)>='A' && plastname.charAt(i)<='Z')){
                        result.rejectValue("PatientLastName",null,"Only letters are allowed");
                        break;
                    }
                }

                if(pemail.equals(patient1.getPatientEmail())){
                    result.rejectValue("PatientEmail",null,"This email id is already in use");
                }
                if(password.length()<=7){
                    result.rejectValue("PatientPassword",null,"password must be more than 8 character");
                }
                if(result.hasErrors()){
                    model.addAttribute("patient",patient);
                    return "PatientSignUp";
                }
            }
        }
         patientService.Signup(patient);
        return "redirect:/Patient/Login?success";
    }

    @GetMapping("/Patient/Logout")
    public String mainpage(){
        return "index";
    }

    @GetMapping("/view/medicine")
    public String viewMedicinebyid(Model model){
        List<Medicine> medicines = new ArrayList<>();
        List<Medicine> medicineList =medicineService.viewall();
        boolean check= false;
        for(Medicine medicine: medicineList) {
            if (id == medicine.getPatientId()) {
                medicines.add(medicine);
                check=true;
            }
        }
        if(!check){
            return "viewMedicineerror";
        }
        model.addAttribute("viewMedicine",medicines);
        return "viewMedicine";
    }

}

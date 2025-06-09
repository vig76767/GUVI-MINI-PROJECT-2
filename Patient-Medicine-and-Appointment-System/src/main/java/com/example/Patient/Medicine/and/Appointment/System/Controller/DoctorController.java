package com.example.Patient.Medicine.and.Appointment.System.Controller;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Appointment;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Repository.DoctorRepository;
import com.example.Patient.Medicine.and.Appointment.System.Service.AppointmentService;
import com.example.Patient.Medicine.and.Appointment.System.Service.DoctorService;
import com.example.Patient.Medicine.and.Appointment.System.Service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
            private MedicineService medicineService;

    @Autowired
            private AppointmentService appointmentService;

    Long id= null;
    @GetMapping("/Doctor/Login")
    public String MainPage(Model model){
        model.addAttribute("doctor",new Doctor());
        return "DoctorLogin";
    }
    @PostMapping("/Doctor/Login/Confirm")
    public String check(@ModelAttribute Doctor doctor){
        List<Doctor> doctorList = doctorService.viewAll();
        for(Doctor doctor1 : doctorList){
            if(doctor1.getDoctorEmail().equals(doctor.getDoctorEmail())){
                if(doctor1.getDoctorPassword().equals(doctor.getDoctorPassword())){
                    id= doctor1.getDoctorId();
                    return "DoctorMainpage";
                }
            }
        }
        return "redirect:/Doctor/Login?failed";
    }
    @GetMapping("/Doctor/Profile")
        public String Myprofile(Model  model){
        List<Doctor> doctorList = doctorService.viewAll();
        for(Doctor doctor1 : doctorList) {
            if(doctor1.getDoctorId() == id){
                model.addAttribute("doctor",doctor1);
                break;
            }
        }
        return "DoctorProfile";

    }

    @GetMapping("/Doctor/SignUp")
    public String Signup(Model model){
        model.addAttribute("doctor",new Doctor());
        return "DoctorSignUp";
    }

    @PostMapping("/Doctor/Signup/Confirm")
    public String signupconfirm(@Valid  @ModelAttribute Doctor doctor, Model model, BindingResult result){
        List<Doctor> DoctorList = doctorService.viewAll();
        if(!DoctorList.isEmpty()) {
            String pfirstname = doctor.getDoctorFristName();
            String plastname  =doctor.getDoctorLastName();
            String pemail = doctor.getDoctorEmail();
            String password = doctor.getDoctorPassword();
            for (Doctor doctor1 : DoctorList) {
                for(int i=0;i<pfirstname.length();i++){
                    if(!(pfirstname.charAt(i)>='a' && pfirstname.charAt(i)<='z' || pfirstname.charAt(i)>='A' && pfirstname.charAt(i)<='Z')){
                        result.rejectValue("doctorFristName",null,"Only letters are allowed");
                        break;
                    }
                }

                for(int i=0;i<plastname .length();i++){
                    if(!(plastname.charAt(i)>='a' && plastname.charAt(i)<='z' || plastname.charAt(i)>='A' && plastname.charAt(i)<='Z')){
                        result.rejectValue("doctorLastName",null,"Only letters are allowed");
                        break;
                    }
                }

                if(pemail.equals(doctor1.getDoctorEmail())){
                    result.rejectValue("doctorEmail",null,"This email id is already in use");
                }
                if(password.length()<=7){
                    result.rejectValue("doctorPassword",null,"password must be more than 8 character");
                }
                if(result.hasErrors()){
                    model.addAttribute("patient",doctor);
                    return "DoctorSignUp";
                }
            }
        }
        doctorService.save(doctor);
        return "redirect:/Doctor/Login?success";
    }
    @GetMapping("/Doctor/Logout")
    public String logout(){
        return "index";
    }

    @GetMapping("/Doctor/ViewAll")
    public String ViewAll(Model model){
        List<Doctor> doctorList = doctorService.viewAll();
        if(doctorList.isEmpty()){
            return"viewDoctorError";
        }
        model.addAttribute("viewall",doctorList);
        return "Doctordetails";
    }
    @GetMapping("/view/medicines")
    public String viewMedicinebyid(Model model){
        List<Medicine> medicines = new ArrayList<>();
        List<Medicine> medicineList =medicineService.viewall();
        for(Medicine medicine: medicineList) {
            if (id == medicine.getDoctorId()) {
                medicines.add(medicine);
            }
        }
        model.addAttribute("viewMedicine",medicines);
        return "viewMedicine";
    }


    @GetMapping("/view/appointment")
    public String viewAppointment(Model model){
        List<Appointment>appointmentList = appointmentService.viewAll();
        List<Appointment> appointmentList1 = new ArrayList<>();
        for(Appointment appointment : appointmentList) {
            if (id ==appointment.getDoctorId()) {
                appointmentList1.add(appointment);
                model.addAttribute("viewall", appointmentList1);
            }
        }
        if(appointmentList1.isEmpty()){
            return "viewAppointmentserror";
        }
        return "viewAppointments";
    }

}

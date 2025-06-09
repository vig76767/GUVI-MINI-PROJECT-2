package com.example.Patient.Medicine.and.Appointment.System.Controller;

import com.example.Patient.Medicine.and.Appointment.System.Entity.Doctor;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Medicine;
import com.example.Patient.Medicine.and.Appointment.System.Entity.Patient;
import com.example.Patient.Medicine.and.Appointment.System.Service.DoctorService;
import com.example.Patient.Medicine.and.Appointment.System.Service.MedicineService;
import com.example.Patient.Medicine.and.Appointment.System.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/ManageMedicine")
    public String index(){
        return "ManageMedicine";
    }

    @GetMapping("/add/Medicine")
    public String addMedicine(Model model){
        model.addAttribute("medicine",new Medicine());
        return "addMedicine";
    }
    @PostMapping("/confirm/medicine")
    public String confirmmedicine(@ModelAttribute Medicine medicine, BindingResult result,Model model){
        List<Patient> patientList = patientService.viewAll();
        List<Doctor> doctorList = doctorService.viewAll();

        boolean pcheck=false;
        for(Patient patient: patientList){
            if(medicine.getPatientId()==patient.getPatientId()){
                pcheck=true;
            }
        }
        if(!pcheck){
            result.rejectValue("PatientId",null,"Invaild patient Id");
        }

        boolean dcheck=false;
        for(Doctor doctor : doctorList){
            if(doctor.getDoctorId()==medicine.getDoctorId()){
                dcheck=true;
            }
        }
        if(!dcheck){
            result.rejectValue("DoctorId",null,"Invaild patient Id");
        }
        if(result.hasErrors()){
            model.addAttribute("medicine",medicine);
            return "addMedicine";
        }
        medicineService.addMedicine(medicine);
        return "redirect:/add/Medicine?success";
    }

    @GetMapping("/delete/medicine")
    public String deletemedicine(){

        return "DeleteMedicine";
    }

    @PostMapping("/delete/medicine/confirm")
    public String deletebyid(@RequestParam("id") Long id){
        List<Medicine> medicineList =medicineService.viewall();
        for(Medicine medicine: medicineList) {
            if (id == medicine.getMedicineId()){
                medicineService.delete(id);
                return "redirect:/delete/medicine?success";
            }
        }
        return "redirect:/delete/medicine?failed";
    }

    @GetMapping("/view/medicine/doctorid")
    public String viewDoctor(Model model){
        List<Medicine> medicineList =medicineService.viewall();
        model.addAttribute("viewall",medicineList);
        return "viewMedicine";
    }


    @GetMapping("/update")
    public String updatemedicine(){
        return "updateMedicine";
    }
    @PostMapping("/update/medicine")
    public String updatebyid(@RequestParam("id") Long id,Model model){
        List<Medicine> medicineList =medicineService.viewall();
        for(Medicine medicine: medicineList) {
            if (id == medicine.getMedicineId()){
                model.addAttribute("update",medicine);
                return "updatevalue";
            }
        }
        return "redirect:/update?failed";
    }
    @PostMapping("/update/new")
    public String updatevalue(@Valid @ModelAttribute Medicine medicine, BindingResult result, Model model){
        List<Patient> patientList = patientService.viewAll();
        List<Doctor> doctorList = doctorService.viewAll();

        boolean pcheck=false;
        for(Patient patient: patientList){
            if(medicine.getPatientId()==patient.getPatientId()){
                pcheck=true;
            }
        }
        if(!pcheck){
            result.rejectValue("PatientId",null,"Invaild patient Id");
        }

        boolean dcheck=false;
        for(Doctor doctor : doctorList){
            if(doctor.getDoctorId()==medicine.getDoctorId()){
                dcheck=true;
            }
        }
        if(!dcheck){
            result.rejectValue("DoctorId",null,"Invaild patient Id");
        }
        if(result.hasErrors()){
            model.addAttribute("medicine",medicine);
            return "addMedicine";
        }
        medicineService.update(medicine);
        return "redirect:/update?success";
    }
}

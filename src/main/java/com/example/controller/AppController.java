package com.example.controller;

import java.util.*;
import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Specialization;
import com.example.model.User;
import com.example.repo.AppRepository;
import com.example.repo.DoctorRepo;
import com.example.repo.SpecRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AppRepository appRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private SpecRepository specRepo;

    @GetMapping("")
    public String homePage(){
        return "HomePage";
    }
    @GetMapping("home")
    public String home(){
        return "HomePage";
    }
    @GetMapping("/collaboration")
    public String collaborationPage(){
        return "collaboration";
    }
    @GetMapping("/service")
    public String servicePage(){
        return "servicePage";
    }


    @GetMapping("/profile")
    public String profilePage(){
        return "profilePage";
    }

    @GetMapping("/regis_landing")
    public String regisPage(){
        return "regis_landing";
    }
    @GetMapping("/company")
    public String companyPage(){
        return "companyPage";
    }
    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("user",new User());
        System.out.println("Halo");
        return "signupPage";
    }

    @GetMapping("/signin")
    public String signinPage(){
        return "signinPage";
    }

    @GetMapping("/appointment")
    public String appointmentPage(Model model){
        model.addAttribute("app",new Appointment());
        List<Doctor> listDoctor = (List<Doctor>) doctorRepo.findAll();
        model.addAttribute("listDoctor",listDoctor);
        List<Specialization> listSpec = (List<Specialization>) specRepo.findAll();
        model.addAttribute("listSpec",listSpec);
        return "appointmentPage";
    }

    @PostMapping("/register")
    public String registerProcess(User user, HttpServletRequest request){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePass = encoder.encode(user.getPassword());
        user.setPassword(encodePass);
        userRepo.save(user);
        System.out.println("Halo");
        return "regis_landing";
    }

    @GetMapping("/account")
    public String appList(Model model){
        List<Appointment> listApp = (List<Appointment>) appRepo.findAll();
        model.addAttribute("listApp",listApp);
        return "applist";
    }

    @PostMapping("/appointment")
    public String addApp(Appointment app){
        appRepo.save(app);
        return "redirect:/account";
    }

    @GetMapping("/account/detail/edit/{id}")
    public String updateAppointment(@PathVariable(value = "id")Integer id, Model model){
        Appointment app = appRepo.getById(id);
        model.addAttribute("app", app);
        return "appointmentEditPage";
    }

    @GetMapping("/account/detail/delete/{id}")
    public String deleteApp(@PathVariable(value = "id")Integer id){
        appRepo.deleteById(id);
        return "redirect:/account";
    }

}

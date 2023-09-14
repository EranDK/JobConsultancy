package com.mycompany.controller;


import com.mycompany.model.Consultant;
import com.mycompany.model.User;
import com.mycompany.service.ConsultantService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsultantController {

    @Autowired
    ConsultantService service;

    @GetMapping("/consultantregistration")
    public String showRegistrationForm(Model model) {
        Consultant consultant = new Consultant();
        model.addAttribute("consultant", new Consultant());
        return "consultantregistration";
    }

    @PostMapping("/consultantregistration/save")
    public String saveConsultant(@ModelAttribute Consultant consultant){
        String hashedPassword = BCrypt.hashpw(consultant.getPassword(),BCrypt.gensalt(12));
        consultant.setPassword(hashedPassword);
       service.save(consultant);
        return "redirect:/consultantlist";
    }



}

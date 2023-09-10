package com.mycompany.controller;


import com.mycompany.model.Consultant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultantController {

    @GetMapping("/consultantregistration")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        Consultant user = new Consultant();
        model.addAttribute("consultant", new Consultant());
        return "consultantregistration";
    }



}

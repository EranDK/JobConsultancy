package com.mycompany.controller;


import com.mycompany.model.Consultant;
import com.mycompany.model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsultantController {

    @GetMapping("/consultantregistration")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        Consultant user = new Consultant();
        model.addAttribute("consultant", new Consultant());
        return "consultantregistration";
    }

    @PostMapping("/consultantregistration/save")
    public String saveUser(User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
        user.setPassword(hashedPassword);
       // service.save(user);
        return "redirect:/login";
    }



}

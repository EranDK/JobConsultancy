package com.mycompany.controller;


import com.mycompany.model.Admin;
import com.mycompany.repository.AdminRepository;
import com.mycompany.service.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private AdminRepository repo;

    @GetMapping("/adminregistration")
    public String showRegistrationForm(Model model){
        //create model object to store form data
        Admin admin = new Admin();
        model.addAttribute("staff", new Admin());
        return "adminegistration";
    }

    @PostMapping("/adminregistration/save")
    public String saveAdmin(Admin admin){
        String hashedPassword = BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt(12));
        admin.setPassword(hashedPassword);
        service.save(admin);
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String showLoginForm(Admin admin) {

        return "admin";
    }

    @PostMapping("/admin")
    public String loginProcess(@RequestParam("email")String email, @RequestParam("password") String password){
        Admin dbAdmin = repo.findByEmail(email);
        Boolean isPasswordMatch= BCrypt.checkpw(password,dbAdmin.getPassword());
        if(isPasswordMatch)
            return "redirect:/adminpage";
        else
            return "redirect:/login";
    }


}
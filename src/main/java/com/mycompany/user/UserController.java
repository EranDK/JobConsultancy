package com.mycompany.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        //create model object to store form data
        User user = new User();
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration/save")
    public String saveUser(User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
        user.setPassword(hashedPassword);
        service.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(User users) {
        return "login";
    }

    @PostMapping("/loginpage")
    public String loginProcess(@RequestParam("email")String email, @RequestParam("password") String password){
        User dbUser = userRepository.findByEmail(email);
        Boolean isPasswordMatch= BCrypt.checkpw(password,dbUser.getPassword());
        if(isPasswordMatch)
            return "redirect:/userhome";
        else
            return "redirect:/login";
    }

    @GetMapping("/userhome")
    public String showUserHome() {
        return "userhome";
    }

    @GetMapping("/appointment")
    public String showAppointment(Model model){
        User user = new User();
        model.addAttribute("user", new User());
        return "appointment";
    }


}

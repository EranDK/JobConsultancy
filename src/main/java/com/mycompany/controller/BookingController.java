package com.mycompany.controller;

import com.mycompany.model.Booking;
import com.mycompany.model.Country;
import com.mycompany.model.Job;
import com.mycompany.repository.BookingRepository;
import com.mycompany.repository.CountryRepository;
import com.mycompany.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository repo;

    @Autowired
    CountryRepository countryrepo;

    @Autowired
    JobRepository jobrepo;

    @GetMapping("/appointments")
    public String showAppointmentPage(Model model){
        List<Country> listCountries= countryrepo.findAll();
        model.addAttribute("listCountries",listCountries);
        List<Job>listJobs = jobrepo.findAll();
        model.addAttribute("listJobs", listJobs);
        model.addAttribute("booking", new Booking());


        return "appointments";
    }

    @GetMapping("/history")
    public String appointmentHistory(Model model){
        List<Booking> listAppointments = repo.findAll();
        model.addAttribute("listAppointments", listAppointments);
        return "history";
    }

    @PostMapping("/appointments/save")
    public String saveBooking(Booking booking){
        repo.save(booking);
        return "redirect:/history";
    }
}
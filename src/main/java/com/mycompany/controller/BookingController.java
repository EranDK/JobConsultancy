package com.mycompany.controller;

import com.mycompany.model.Booking;
import com.mycompany.model.Country;
import com.mycompany.model.Job;
import com.mycompany.service.BookingService;
import com.mycompany.service.CountryService;
import com.mycompany.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private JobService jobService;

    @GetMapping("/appointments")
    public String showAppointmentPage(Model model){
        List<Country> listCountries= countryService.getAllCountries();
        model.addAttribute("listCountries",listCountries);
        List<Job>listJobs = jobService.getAllJobs();
        model.addAttribute("listJobs", listJobs);
        Booking booking = new Booking();
        model.addAttribute("booking", new Booking());
        return "appointments";
    }

    @PostMapping("/appointments/save")
    public String saveAppointment(@ModelAttribute Booking booking){
        bookingService.save(booking);
        return "redirect:/history";
    }

    @GetMapping("/history")
    public ModelAndView getAllBooking(){
        List<Booking> listAppointments = bookingService.getAllBooking();
        return new ModelAndView("history","listAppointments",listAppointments);
    }

    @RequestMapping("/deleteAppointmentList/{id}")
    public String deleteAppointmentList(@PathVariable("id") int id){
        bookingService.deleteById(id);
        return "redirect:/history";
    }

    @RequestMapping("/editAppointment/{id}")
    public String editCountry(@PathVariable("id") int id, Model model){
        Booking booking = bookingService.getBookingById(id);
        List<Country>listCountries= countryService.getAllCountries();
        model.addAttribute("listCountries",listCountries);
        List<Job>listJobs = jobService.getAllJobs();
        model.addAttribute("listJobs", listJobs);
        model.addAttribute("booking", booking);
        return "appointmentsedit";
    }


    @PostMapping("/appointments/update")
    public String updateAppointment(@ModelAttribute Booking booking){
        bookingService.save(booking);
        return "redirect:/history";
    }

}

package com.mycompany.controller;

import com.mycompany.model.Job;
import com.mycompany.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String showJobForm(Model model){
        Job job = new Job();
        model.addAttribute("job", new Job());
        return "jobs";
    }

    @PostMapping("/jobs/save")
    public String saveJobs(@ModelAttribute Job job){
        jobService.save(job);
        return "redirect:/jobTable";
    }

    @GetMapping("/jobTable")
    public ModelAndView getAllJobs(){
        List <Job> job = jobService.getAllJobs();
        return new ModelAndView("jobTable","job",job);
    }

    @RequestMapping("/deletejobTable/{id}")
    public String deletejobTable(@PathVariable("id") int id){
        jobService.deleteById(id);
        return "redirect:/jobTable";
    }

    @RequestMapping("/jobEdit/{id}")
    public String jobEdit(@PathVariable("id") int id, Model model){
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "jobEdit";
    }

}
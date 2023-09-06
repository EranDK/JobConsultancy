package com.mycompany.controller;

import com.mycompany.repository.JobRepository;
import com.mycompany.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @Autowired
    private JobRepository repo;

    @GetMapping("/jobs")
    public String showJobPage(Model model){
        model.addAttribute("Job" , new Job());
        return "jobs";
    }

    @PostMapping("/jobs/save")
    public String addJobList(Job job) {
        repo.save(job);
        return "jobs";
    }



}

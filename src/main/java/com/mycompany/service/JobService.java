package com.mycompany.service;


import com.mycompany.model.Job;
import com.mycompany.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobrepo;

    public void save(Job job){
        jobrepo.save(job);
    }

    public List<Job> getAllJobs(){
        return jobrepo.findAll();
    }

    public void deleteById(int id){
        jobrepo.deleteById(id);
    }

    public Job getJobById(int id){
        return jobrepo.findById(id).get();
    }
}

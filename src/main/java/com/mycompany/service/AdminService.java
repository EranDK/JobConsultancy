package com.mycompany.service;


import com.mycompany.model.Admin;
import com.mycompany.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public void save(Admin admin){

       repo.save(admin);
    }

}
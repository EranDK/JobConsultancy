package com.mycompany.staff;


import com.mycompany.staff.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public void save(Admin admin){

       repo.save(admin);
    }

}
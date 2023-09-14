package com.mycompany.service;

import com.mycompany.model.Consultant;
import com.mycompany.model.User;
import com.mycompany.repository.ConsultantRepository;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultantService {

    @Autowired
    private ConsultantRepository repo;

    public void save(Consultant consultant){
        repo.save(consultant);
    }


}


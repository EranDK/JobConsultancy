package com.mycompany.repository;

import com.mycompany.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    Admin findByEmail(String email);

}

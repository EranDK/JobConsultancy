package com.mycompany.staff;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Integer> {
    Country findById(String id);

}


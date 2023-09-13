package com.mycompany.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100,nullable = false,unique = true )
    private String name;

    public Job(){

    }

    public Job(Integer id){

        this.id =id;
    }

    public Job(String name){
        this.name = name;
    }

    public Integer getId(){

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

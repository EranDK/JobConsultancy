package com.mycompany.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private String time;

    @ManyToOne
    @JoinColumn(name="country_id")
    private  Country country;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job jobtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Job getJobtype() {
        return jobtype;
    }

    public void setJobtype(Job jobtype) {
        this.jobtype = jobtype;
    }
}

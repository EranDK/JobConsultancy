package com.mycompany;


import com.mycompany.model.Job;
import com.mycompany.model.User;
import com.mycompany.repository.JobRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class JobRepositoryTest {

    @Autowired
    JobRepository jobRepository;


    @Test
    public void testAddJob(){

        Job savedJob = jobRepository.save(new Job("Marketing2"));
        Assertions.assertThat(savedJob.getId()).isGreaterThan(0);

    }

    @Test
    public void testUpdate(){
        Integer jobid=3;
        Optional<Job> optionalJob=jobRepository.findById(jobid);

        Job job =optionalJob.get();
        job.setName("testJob");
        jobRepository.save(job);

        Job updateJob=jobRepository.findById(jobid).get();
        Assertions.assertThat(updateJob.getName()).isEqualTo("testJob");
    }


    @Test
    public void testDelete(){
        Integer jobid=12;
        jobRepository.deleteById(jobid);

        Optional<Job> optionalJob=jobRepository.findById(jobid);
        Assertions.assertThat(optionalJob).isNotPresent();
    }


    }



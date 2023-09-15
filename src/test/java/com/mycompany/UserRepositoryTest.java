package com.mycompany;


import com.mycompany.model.User;
import com.mycompany.repository.UserRepository;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("pathrickhart@gmail.com");
        user.setPassword("patrick.123");
        user.setFirstName("Patrick");
        user.setLastName("Hartmann");


        User savedUser =userRepository.save(user);
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<User> users =userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userid=4;
        Optional<User> optionalUser=userRepository.findById(userid);

        User user =optionalUser.get();
        user.setFirstName("Welma");
        userRepository.save(user);

        User updateUser=userRepository.findById(userid).get();
        Assertions.assertThat(updateUser.getFirstName()).isEqualTo("Welma");
    }

    @Test
    public void testDelete(){
        Integer userid=7;
        userRepository.deleteById(userid);

        Optional<User> optionalUser=userRepository.findById(userid);
        Assertions.assertThat(optionalUser).isNotPresent();
    }


}

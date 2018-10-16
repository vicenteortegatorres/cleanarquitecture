package com.coconutcode.user.external.database;

import com.coconutcode.user.Application;
import com.coconutcode.user.adapter.persistence.model.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class UserDataRepositoryIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() {
        assertFalse(userRepository.findByUsername("vicenteortega").isPresent());

        userRepository.save(new UserData("vicenteortega"));

        assertTrue(userRepository.findByUsername("vicenteortega").isPresent());
    }
}

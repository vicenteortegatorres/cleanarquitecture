package com.coconutcode.user.entity;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    @Test(expected = UsernameNotIncluded.class)
    public void userNotCreatedIfUsernameIsNotIncluded() throws UsernameNotIncluded {
        new User(null);
    }

    @Test
    public void userCreatedIfUsernameIncluded() throws UsernameNotIncluded {
        val user = new User("vicenteortega");

        assertEquals("vicenteortega", user.getUsername());
    }
}

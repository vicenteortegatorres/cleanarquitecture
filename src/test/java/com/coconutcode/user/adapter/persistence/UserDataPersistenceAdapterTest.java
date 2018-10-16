package com.coconutcode.user.adapter.persistence;

import com.coconutcode.user.entity.User;
import com.coconutcode.user.external.database.UserRepository;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDataPersistenceAdapterTest {
    @Captor
    private ArgumentCaptor<com.coconutcode.user.adapter.persistence.model.UserData> userArgumentCaptor;

    @Mock
    private UserRepository userRepository;

    private UserPersistenceAdapter userPersistenceAdapter;

    @Before
    public void before() {
        userPersistenceAdapter = new UserPersistenceAdapter(userRepository);
    }

    @Test
    public void userIsCreated() {
        when(userRepository.save(userArgumentCaptor.capture())).thenReturn(
                new com.coconutcode.user.adapter.persistence.model.UserData("vicenteortega"));

        assertEquals("vicenteortega",
                userPersistenceAdapter.createUser(new User("vicenteortega")).getUsername());

        assertEquals("vicenteortega", userArgumentCaptor.getValue().getUsername());
    }

    @Test
    public void userIsFound() {
        when(userRepository.findByUsername("vicenteortega")).thenReturn(Optional.of(
                new com.coconutcode.user.adapter.persistence.model.UserData("vicenteortega")));

        val user = userPersistenceAdapter.getUser("vicenteortega");
        assertTrue(user.isPresent());
        assertEquals("vicenteortega", user.get().getUsername());
    }

    @Test
    public void userIsNotFound() {
        val user = userPersistenceAdapter.getUser("vicenteortega");
        assertFalse(user.isPresent());
    }
}
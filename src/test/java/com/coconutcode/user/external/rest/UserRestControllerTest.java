package com.coconutcode.user.external.rest;

import com.coconutcode.user.adapter.presenter.UserPresenterAdapter;
import com.coconutcode.user.adapter.presenter.model.UserView;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {
    @Mock
    private UserView user;

    @Mock
    private UserPresenterAdapter userPresenterAdapter;

    @InjectMocks
    private UserRestController userRestController;

    @Test
    public void returnsOkIfUserCreated() {
        when(userPresenterAdapter.createUser(any(UserView.class))).thenReturn(user);

        val response = userRestController.create(new UserView("vicenteortega"));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void returnsBadRequestIfUserNotCreated() {
        when(userPresenterAdapter.createUser(any(UserView.class))).thenThrow(new RuntimeException());

        val response = userRestController.create(new UserView("exception"));

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}

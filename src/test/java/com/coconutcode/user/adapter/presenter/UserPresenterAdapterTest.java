package com.coconutcode.user.adapter.presenter;

import com.coconutcode.user.adapter.presenter.model.UserView;
import com.coconutcode.user.entity.User;
import com.coconutcode.user.usecases.CreateUserUseCase;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPresenterAdapterTest {

    private UserPresenterAdapter userPresenterAdapter;

    @Mock
    private CreateUserUseCase createUserUseCase;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;


    @Before
    public void before() {
        userPresenterAdapter = new UserPresenterAdapter(createUserUseCase);
    }

    @Test
    public void userIsCreated() {
        val user = new UserView("vicenteortega");

        when(createUserUseCase.createUser(any(User.class))).thenReturn(new User("vicenteortega"));

        userPresenterAdapter.createUser(user);

        verify(createUserUseCase).createUser(userArgumentCaptor.capture());

        assertEquals("vicenteortega", userArgumentCaptor.getValue().getUsername());
    }
}

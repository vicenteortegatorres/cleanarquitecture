package com.coconutcode.user.usecases;

import com.coconutcode.user.entity.User;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserDataUseCaseTest {
    @Mock
    private User user;

    @Mock
    private CreateUser createUser;

    @Mock
    private GetUser getUser;

    private CreateUserUseCase createUserUseCase;

    @Before
    public void before() {
        createUserUseCase = new CreateUserUseCase(createUser, getUser);
    }

    @Test(expected = MandatoryValueNotIncludedException.class)
    public void userIsNotCreatedIfInputUserIsEmpty(){
        createUserUseCase.createUser(null);

        verify(createUser, never()).createUser(any(User.class));
    }

    @Test(expected = MandatoryValueNotIncludedException.class)
    public void userIsNotCreatedIfInputUsernameAlreadyUsed(){
        when(getUser.getUser("Vicente")).thenReturn(Optional.empty());

        val newUser = new User("Vicente");

        when(getUser.getUser("Vicente")).thenReturn(Optional.of(user));

        createUserUseCase.createUser(newUser);

        verify(createUser, never()).createUser(any(User.class));
    }

    @Test
    public void userIsCreatedIfUserIsIncluded(){
        when(getUser.getUser("Vicente")).thenReturn(Optional.empty());

        val newUser = new User("Vicente");

        when(createUser.createUser(newUser)).thenReturn(user);

        val result = createUserUseCase.createUser(newUser);

        assertThat(result, equalTo(user));
    }
}

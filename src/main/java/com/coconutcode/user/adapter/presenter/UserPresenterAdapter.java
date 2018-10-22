package com.coconutcode.user.adapter.presenter;

import com.coconutcode.user.entity.User;
import com.coconutcode.user.usecases.CreateUserUseCase;
import com.coconutcode.user.adapter.presenter.model.UserView;

public class UserPresenterAdapter {
    private final CreateUserUseCase createUserUseCase;

    public UserPresenterAdapter(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    public UserView createUser(UserView user) {
        return new UserView(createUserUseCase.createUser(new User(user.getUsername())));
    }
}

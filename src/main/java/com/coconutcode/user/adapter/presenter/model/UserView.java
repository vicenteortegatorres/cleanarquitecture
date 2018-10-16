package com.coconutcode.user.adapter.presenter.model;

import com.coconutcode.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserView implements Serializable {
    private String username;

    public UserView(User user){
        this(user.getUsername());
    }

    public UserView(){

    }
}

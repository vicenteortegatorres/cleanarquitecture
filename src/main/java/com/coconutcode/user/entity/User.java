package com.coconutcode.user.entity;

import lombok.Getter;

import java.util.Optional;

@Getter
public class User {
    private String username;

    public User(String username) throws UsernameNotIncluded {
        if(Optional.ofNullable(username).isPresent()) {
            this.username = username;
        } else {
            throw new UsernameNotIncluded();
        }
    }
}

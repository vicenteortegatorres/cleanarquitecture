package com.coconutcode.user.usecases;

import com.coconutcode.user.entity.User;

import java.util.Optional;

public interface GetUser {
    Optional<User> getUser(String username);
}

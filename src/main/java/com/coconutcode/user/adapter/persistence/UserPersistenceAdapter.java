package com.coconutcode.user.adapter.persistence;

import com.coconutcode.user.entity.User;
import com.coconutcode.user.usecases.CreateUser;
import com.coconutcode.user.usecases.GetUser;
import com.coconutcode.user.external.database.UserRepository;
import lombok.val;

import java.util.Optional;

public class UserPersistenceAdapter implements CreateUser, GetUser {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        val newUser = userRepository.save(new com.coconutcode.user.adapter.persistence.model.UserData(user.getUsername()));
        return new User(newUser.getUsername());
    }

    @Override
    public Optional<User> getUser(String username) {
        val optionalUser = userRepository.findByUsername(username);
        return optionalUser.map(user -> new User(user.getUsername()));
    }
}

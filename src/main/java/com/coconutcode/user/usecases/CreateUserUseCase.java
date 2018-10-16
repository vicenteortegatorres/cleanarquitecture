package com.coconutcode.user.usecases;

import com.coconutcode.user.entity.User;
import lombok.AllArgsConstructor;
import java.util.Optional;

@AllArgsConstructor
public class CreateUserUseCase {
    private CreateUser createUser;

    private GetUser getUser;

    public User createUser(User user) throws MandatoryValueNotIncludedException {
        if(userIncluded(user)) {
            if(usernameAlreadyUsed(user)) {
                throw new MandatoryValueNotIncludedException("Username already exists: " + user.getUsername());
            } else {
                return createUser.createUser(user);
            }
        } else {
            throw new MandatoryValueNotIncludedException("User not included");
        }
    }

    private boolean usernameAlreadyUsed(User user) {
        return getUser.getUser(user.getUsername()).isPresent();
    }

    private boolean userIncluded(User user) {
        return Optional.ofNullable(user).isPresent();
    }
}

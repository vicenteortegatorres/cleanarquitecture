package com.coconutcode.user.configuration;

import com.coconutcode.user.adapter.persistence.UserPersistenceAdapter;
import com.coconutcode.user.external.database.UserRepository;
import com.coconutcode.user.usecases.CreateUser;
import com.coconutcode.user.usecases.CreateUserUseCase;
import com.coconutcode.user.usecases.GetUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CreateUserUseCase createCreeateUserUseCase(CreateUser createUser, GetUser getUser) {
        return new CreateUserUseCase(createUser, getUser);
    }

    @Bean
    public UserPersistenceAdapter createUserPersistenceAdapter(UserRepository userRepository) {
        return new UserPersistenceAdapter(userRepository);
    }
}

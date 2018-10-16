package com.coconutcode.user.external.database;

import com.coconutcode.user.adapter.persistence.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<UserData, Long>{
    Optional<UserData> findByUsername(String username);
}

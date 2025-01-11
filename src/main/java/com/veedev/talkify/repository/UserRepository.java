package com.veedev.talkify.repository;

import com.veedev.talkify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByNumberPhone(String numberPhone);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

    User findByNumberPhone(String numberPhone);
    User findByEmail(String email);
}

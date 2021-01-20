package com.authyd.springsecuritydb.repository;

import com.authyd.springsecuritydb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

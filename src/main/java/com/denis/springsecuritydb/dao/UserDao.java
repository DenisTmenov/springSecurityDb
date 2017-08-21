package com.denis.springsecuritydb.dao;

import com.denis.springsecuritydb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

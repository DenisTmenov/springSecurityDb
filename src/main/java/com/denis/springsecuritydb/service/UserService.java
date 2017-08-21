package com.denis.springsecuritydb.service;

import com.denis.springsecuritydb.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

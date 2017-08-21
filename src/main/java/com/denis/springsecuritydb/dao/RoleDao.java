package com.denis.springsecuritydb.dao;

import com.denis.springsecuritydb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}

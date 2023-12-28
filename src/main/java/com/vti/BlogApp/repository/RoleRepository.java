package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByType(Role.Type type);
}

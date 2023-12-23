package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

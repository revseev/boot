package com.javamentor.revseev.boot.dao;

import com.javamentor.revseev.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

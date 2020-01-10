package com.javamentor.revseev.boot.dao;

import com.javamentor.revseev.boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByType(String type);
}

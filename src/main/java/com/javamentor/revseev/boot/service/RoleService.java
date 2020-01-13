package com.javamentor.revseev.boot.service;


import com.javamentor.revseev.boot.model.Role;

import java.util.List;

public interface RoleService {

    Role findById(long id);

    Role findByType(String type);

    List<Role> getAll();

}

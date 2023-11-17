package com.example.confiserie.service;

import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.enums.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findByName(RoleNameEnum roleNameEnum);
}

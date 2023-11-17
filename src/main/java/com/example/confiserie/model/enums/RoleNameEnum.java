package com.example.confiserie.model.enums;

import java.util.Collections;
import java.util.Set;

import static com.example.confiserie.model.enums.PermissionEnum.*;

public enum RoleNameEnum {

    USER(Collections.emptySet()),
    MANAGER(Set.of(MANAGER_READ, MANAGER_CREATE, MANAGER_UPDATE, MANAGER_DELETE)),
    ADMIN(Set.of(ADMIN_READ, ADMIN_CREATE, ADMIN_UPDATE, ADMIN_DELETE, MANAGER_READ, MANAGER_CREATE, MANAGER_UPDATE, MANAGER_DELETE));

    private Set<PermissionEnum> permissions;

    RoleNameEnum(Set<PermissionEnum> permissions) {
        this.permissions = permissions;
    }

    public Set<PermissionEnum> getPermissions() {
        return permissions;
    }
}

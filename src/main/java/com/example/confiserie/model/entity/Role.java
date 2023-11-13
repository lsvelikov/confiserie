package com.example.confiserie.model.entity;

import com.example.confiserie.model.enums.RoleNameEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public RoleNameEnum getName() {
        return name;
    }

    public Role setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Role setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}

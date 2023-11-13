package com.example.confiserie.repository;

import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleNameEnum name);
}

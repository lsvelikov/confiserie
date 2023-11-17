package com.example.confiserie.repository;

import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleNameEnum name);
}

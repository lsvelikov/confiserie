package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.enums.RoleNameEnum;
import com.example.confiserie.repository.RoleRepository;
import com.example.confiserie.service.RoleService;
import com.example.confiserie.service.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {

        if (roleRepository.count() == 0) {

            Arrays.stream(RoleNameEnum.values())
                    .forEach(r -> {
                        Role role = new Role();
                        role.setName(r);

                        roleRepository.save(role);
                    });
        }
    }

    @Override
    public Role findByName(RoleNameEnum roleNameEnum) {
        return roleRepository.findByName(roleNameEnum)
                .orElseThrow(() -> new ObjectNotFoundException("Role does not exist"));
    }
}

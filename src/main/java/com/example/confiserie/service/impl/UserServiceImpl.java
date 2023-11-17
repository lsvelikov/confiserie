package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.UserRegisterDto;
import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.entity.User;
import com.example.confiserie.model.enums.RoleNameEnum;
import com.example.confiserie.repository.UserRepository;
import com.example.confiserie.service.RoleService;
import com.example.confiserie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = mapper.map(userRegisterDto, User.class);
        user
                .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()))
                .setRoles(Arrays.asList(roleService.findByName(RoleNameEnum.USER)));

        userRepository.save(user);
    }

    @Override
    public void initUser() {

        Role adminRole = roleService.findByName(RoleNameEnum.ADMIN);
        Role managerRole = roleService.findByName(RoleNameEnum.MANAGER);
        Role userRole = roleService.findByName(RoleNameEnum.USER);

        if (userRepository.count() == 0) {

            User admin = new User();
            admin.setFirstName("Peter")
                    .setLastName("Petrov")
                    .setAddress("Choper 12")
                    .setEmail("peter@abv.bg")
                    .setPhoneNumber("00359 898 111 222")
                    .setPassword(passwordEncoder.encode("qwe"))
                    .setRoles(Arrays.asList(adminRole, managerRole, userRole));

            userRepository.save(admin);
        }
    }
}


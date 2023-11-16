package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.UserRegisterDto;
import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.entity.User;
import com.example.confiserie.model.enums.RoleNameEnum;
import com.example.confiserie.repository.RoleRepository;
import com.example.confiserie.repository.UserRepository;
import com.example.confiserie.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user
                .setFirstName(userRegisterDto.getFirstName())
                .setLastName(userRegisterDto.getLastName())
                .setAddress(userRegisterDto.getAddress())
                .setEmail(userRegisterDto.getEmail())
                .setPhoneNumber(userRegisterDto.getPhoneNumber())
                .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()))
                .setRoles(Arrays.asList(roleRepository.findByName(RoleNameEnum.USER)));

        userRepository.save(user);
    }

    @Override
    public void initUser() {

        if (userRepository.count() == 0 && roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName(RoleNameEnum.ADMIN);
            roleRepository.save(adminRole);

            Role managerRole = new Role();
            managerRole.setName(RoleNameEnum.MANAGER);
            roleRepository.save(managerRole);

            Role userRole = new Role();
            userRole.setName(RoleNameEnum.USER);
            roleRepository.save(userRole);

            User admin = new User();
            admin.setFirstName("Peter")
                    .setLastName("Petrov")
                    .setAddress("Choper 12")
                    .setEmail("peter@abv.bg")
                    .setPhoneNumber("00359 898 111 222")
                    .setPassword(passwordEncoder.encode("qwe"))
                    .setRoles(Arrays.asList(adminRole, userRole));

            userRepository.save(admin);


        }
    }

}

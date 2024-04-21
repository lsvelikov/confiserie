package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.UserRegisterDto;
import com.example.confiserie.model.dtos.UserViewDto;
import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.entity.User;
import com.example.confiserie.model.enums.RoleNameEnum;
import com.example.confiserie.repository.UserRepository;
import com.example.confiserie.service.RoleService;
import com.example.confiserie.service.UserService;
import com.example.confiserie.exeption.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
//        Role managerRole = roleService.findByName(RoleNameEnum.MANAGER);
//        Role userRole = roleService.findByName(RoleNameEnum.USER);

        if (userRepository.count() == 0) {

            User admin = new User();
            admin.setFirstName("Peter")
                    .setLastName("Petrov")
                    .setAddress("Choper 12")
                    .setEmail("peter@abv.bg")
                    .setPhoneNumber("00359 898 111 222")
                    .setPassword(passwordEncoder.encode("qwe"))
                    .setRoles(Collections.singletonList(adminRole));

            userRepository.save(admin);
        }
    }

    @Override
    public List<UserViewDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .filter(this::isUser)
                .map(user -> mapper.map(user, UserViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserViewDto> findAllAdmins() {
        return userRepository.findAll()
                .stream()
                .filter(this::isAdmin)
                .map(user -> mapper.map(user, UserViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserViewDto> findAllManagers() {
        return userRepository.findAll()
                .stream()
                .filter(this::isManager)
                .map(user -> mapper.map(user, UserViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void makeAdmin(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

        List <Role> roles = user.getRoles();
        Role currentRole = user.getRoles().get(0);
        roles.remove(currentRole);
        Role adminRole = roleService.findByName(RoleNameEnum.ADMIN);
        if (!roles.contains(adminRole)) {
            roles.add(adminRole);
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

    @Override
    public void makeManager(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

        List<Role> roles = user.getRoles();
        Role currentRole = user.getRoles().get(0);
        roles.remove(currentRole);
        Role managerRole = roleService.findByName(RoleNameEnum.MANAGER);
        roles.add(managerRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void deleteManager(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

        List<Role> roles = user.getRoles();
        Role currentRole = user.getRoles().get(0);
        roles.remove(currentRole);
        Role roleUser = roleService.findByName(RoleNameEnum.USER);
        roles.add(roleUser);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    private boolean isAdmin(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getName)
                .anyMatch(roleNameEnum -> roleNameEnum == RoleNameEnum.ADMIN);
    }

    private boolean isManager(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getName)
                .anyMatch(roleNameEnum -> roleNameEnum == RoleNameEnum.MANAGER);
    }

    private boolean isUser(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getName)
                .noneMatch(roleNameEnum -> (roleNameEnum == RoleNameEnum.MANAGER || roleNameEnum == RoleNameEnum.ADMIN));
    }
}


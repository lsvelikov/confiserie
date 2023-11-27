package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Role;
import com.example.confiserie.model.entity.User;
import com.example.confiserie.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class ConfiUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public ConfiUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(ConfiUserDetailService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + "not found!"));
    }

    private static UserDetails map(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles()
                        .stream()
                        .map(ConfiUserDetailService::map)
                        .collect(Collectors.toList()))
                .build();

    }

    private static GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getName().name());
    }
}

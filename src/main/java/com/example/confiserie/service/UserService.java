package com.example.confiserie.service;

import com.example.confiserie.model.dtos.UserRegisterDto;
import com.example.confiserie.model.dtos.UserViewDto;

import java.util.List;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void initUser();


    List<UserViewDto> findAllUsers();

    List<UserViewDto> findAllAdmins();

    void makeAdmin(Long id);

    List<UserViewDto> findAllManagers();

    void makeManager(Long id);

    void deleteManager(Long id);
}

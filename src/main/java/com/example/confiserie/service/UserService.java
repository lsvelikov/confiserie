package com.example.confiserie.service;

import com.example.confiserie.model.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void initUser();
}

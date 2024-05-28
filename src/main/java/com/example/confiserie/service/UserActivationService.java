package com.example.confiserie.service;

public interface UserActivationService {

//    void userRegistered(UserRegisteredEvent event);
    String createActivationCode(String userEmail);
}

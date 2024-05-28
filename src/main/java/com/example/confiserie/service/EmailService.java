package com.example.confiserie.service;

public interface EmailService {

    void sendRegistrationEmail(String userEmail, String userName, String activationCode);
}

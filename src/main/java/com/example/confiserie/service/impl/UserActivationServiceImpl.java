package com.example.confiserie.service.impl;

import com.example.confiserie.exeption.ObjectNotFoundException;
import com.example.confiserie.model.entity.UserActivationCode;
import com.example.confiserie.model.events.UserRegisteredEvent;
import com.example.confiserie.repository.UserActivationCodeRepository;
import com.example.confiserie.repository.UserRepository;
import com.example.confiserie.service.EmailService;
import com.example.confiserie.service.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ACTIVATION_CODE_LENGTH = 17;

    private final EmailService emailService;

    private final UserRepository userRepository;

    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationServiceImpl(EmailService emailService, UserRepository userRepository, UserActivationCodeRepository userActivationCodeRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());
        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserName(), activationCode);
    }

    @Override
    public String createActivationCode(String userEmail) {
        String activationCode = generateActivationCode();

        UserActivationCode userActivationCode = new UserActivationCode();

        userActivationCode.setActivationCode(activationCode);
        userActivationCode.setCreated(Instant.now());
        userActivationCode.setUser(userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException("User with email " + userEmail + " not found")));

        userActivationCodeRepository.save(userActivationCode);

        return activationCode;
    }

    private String generateActivationCode() {
        Random random = new SecureRandom();
        StringBuilder activationCode = new StringBuilder();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randomIndex));
        }

        return activationCode.toString();
    }
}

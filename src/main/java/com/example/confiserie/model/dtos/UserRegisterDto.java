package com.example.confiserie.model.dtos;

import com.example.confiserie.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    @NotNull
    @NotBlank(message = "This field cannot be empty")
    private String firstName;
    @NotNull
    @NotBlank(message = "This field cannot be empty")
    private String lastName;
    @NotNull
    @NotBlank(message = "This field cannot be empty")
    private String address;
    @Email
    @NotBlank(message = "Email cannot be empty")
    @UniqueUserEmail
    private String email;
    @NotNull
    @NotBlank(message = "This field cannot be empty")
    private String phoneNumber;
    @Size(min = 2, max = 20, message = "Username length must be between 2 and 20 characters")
    private String username;
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    @NotNull
    private String password;
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    @NotNull
    private String confirmPassword;

    public UserRegisterDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserRegisterDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

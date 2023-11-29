package com.example.confiserie.model.dtos;

public class UserViewDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserViewDto() {
    }

    public Long getId() {
        return id;
    }

    public UserViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewDto setEmail(String email) {
        this.email = email;
        return this;
    }
}

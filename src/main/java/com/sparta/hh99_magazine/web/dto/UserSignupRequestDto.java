package com.sparta.hh99_magazine.web.dto;

public class UserSignupRequestDto {
    private String username;
    private String name;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserSignupRequestDto(){}

    public UserSignupRequestDto(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }
}

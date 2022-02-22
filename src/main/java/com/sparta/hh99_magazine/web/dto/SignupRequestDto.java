package com.sparta.hh99_magazine.web.dto;

public class SignupRequestDto {
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

    public SignupRequestDto(){}

    public SignupRequestDto(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }
}

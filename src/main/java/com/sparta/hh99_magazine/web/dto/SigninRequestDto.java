package com.sparta.hh99_magazine.web.dto;

public class SigninRequestDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public SigninRequestDto() {
    }

    public SigninRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

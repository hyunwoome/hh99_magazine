package com.sparta.hh99_magazine.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignupRequestDto {
    private String username;
    private String name;
    private String password;
}

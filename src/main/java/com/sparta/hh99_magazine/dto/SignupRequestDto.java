package com.sparta.hh99_magazine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String name;
    private String password;
    private String check_password;
}

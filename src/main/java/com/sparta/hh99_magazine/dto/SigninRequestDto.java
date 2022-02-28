package com.sparta.hh99_magazine.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SigninRequestDto {
    private final String username;
    private final String password;
}

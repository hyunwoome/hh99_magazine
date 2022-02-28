package com.sparta.hh99_magazine.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class SigninResponseDto {
    private final Long userId;
    private final String username;
    private final String name;
    private final String token;
}

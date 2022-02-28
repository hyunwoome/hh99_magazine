package com.sparta.hh99_magazine.message;

import com.sparta.hh99_magazine.dto.SigninResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageDataResponse {
    private final String message;
    private final SigninResponseDto data;
}

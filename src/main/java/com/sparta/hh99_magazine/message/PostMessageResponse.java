package com.sparta.hh99_magazine.message;

import com.sparta.hh99_magazine.dto.PostResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostMessageResponse {
    private final String message;
    private final PostResponseDto postResponseDto;
}

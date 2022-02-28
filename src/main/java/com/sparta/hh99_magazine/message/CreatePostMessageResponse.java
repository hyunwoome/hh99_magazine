package com.sparta.hh99_magazine.message;

import com.sparta.hh99_magazine.dto.CreatePostResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreatePostMessageResponse {
    private final String message;
    private final CreatePostResponseDto createPostResponseDto;
}

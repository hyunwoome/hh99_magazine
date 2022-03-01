package com.sparta.hh99_magazine.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class PostResponseDto {
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long postId;
    private final String imgUrl;
    private final String contents;
    private final Long userId;
    private final int likeCnt;
    private final boolean isLike;
}

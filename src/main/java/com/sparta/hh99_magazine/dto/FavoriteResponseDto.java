package com.sparta.hh99_magazine.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FavoriteResponseDto {
    private final Long userId;
    private final Long postId;

    private final String imgUrl;
    private final String content;
    private final String createDate;
    private final String modifiedDate;

    private final String username;
    private final String name;

    private final int cntLike;
    private final boolean isLike;
}

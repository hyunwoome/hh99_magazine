package com.sparta.hh99_magazine.dto;

import com.sparta.hh99_magazine.domain.Favorite;
import com.sparta.hh99_magazine.domain.Post;
import com.sparta.hh99_magazine.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Builder
public class CreatePostResponseDto {
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long postId;
    private final String imgUrl;
    private final String contents;
    private final Long userId;
    private final int likeCnt;
    private final boolean isLike;
}

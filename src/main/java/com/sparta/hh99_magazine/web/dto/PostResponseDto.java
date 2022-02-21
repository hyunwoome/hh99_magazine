package com.sparta.hh99_magazine.web.dto;

import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;

public class PostResponseDto {
    private String contents;
    private String imgUrl;
    private User userId;

    public PostResponseDto() {
    }

    public PostResponseDto(String contents, String imgUrl, User userId) {
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.userId = userId;
    }

    public PostResponseDto(Post post) {
        this.contents = post.getContents();
        this.imgUrl = post.getImgUrl();
        this.userId = post.getUserId();
    }
}

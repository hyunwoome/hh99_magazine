package com.sparta.hh99_magazine.web.dto;

import com.sparta.hh99_magazine.domain.user.User;

public class PostRequestDto {
    private String contents;
    private String imgUrl;
    private User userId;

    public String getContents() {
        return contents;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public User getUserId() {
        return userId;
    }
}

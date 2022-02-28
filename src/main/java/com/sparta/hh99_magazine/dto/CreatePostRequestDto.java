package com.sparta.hh99_magazine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequestDto {
    private String imgUrl;
    private String contents;
}

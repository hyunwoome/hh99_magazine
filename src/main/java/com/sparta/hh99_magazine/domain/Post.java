package com.sparta.hh99_magazine.domain;

import com.sparta.hh99_magazine.dto.CreatePostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(CreatePostRequestDto createPostRequestDto) {
        this.imgUrl = createPostRequestDto.getImgUrl();
        this.contents = createPostRequestDto.getContents();
    }
}

package com.sparta.hh99_magazine.domain.post;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
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

    public Post(String imgUrl, String contents, User user) {
        this.imgUrl = imgUrl;
        this.contents = contents;
        this.user = user;
    }

    public void update(PostRequestDto postRequestDto) {
        this.imgUrl = postRequestDto.getImgUrl();
        this.contents = postRequestDto.getContents();
    }
}

package com.sparta.hh99_magazine.domain.post;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;


    public Post(PostRequestDto postRequestDto) {
        this.contents = postRequestDto.getContents();
        this.imgUrl = postRequestDto.getImgUrl();
    }
}

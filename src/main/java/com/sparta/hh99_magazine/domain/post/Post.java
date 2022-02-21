package com.sparta.hh99_magazine.domain.post;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.domain.user.User;

import javax.persistence.*;

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
    private User userId;
}

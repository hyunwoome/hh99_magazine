package com.sparta.hh99_magazine.domain.favorite;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;

import javax.persistence.*;

@Entity
public class Favorite extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY)
    private Post postId;

    @ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY)
    private User userId;
}

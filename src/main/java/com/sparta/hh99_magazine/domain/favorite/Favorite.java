package com.sparta.hh99_magazine.domain.favorite;

import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Favorite(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}

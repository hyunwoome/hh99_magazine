package com.sparta.hh99_magazine.domain;

import javax.persistence.*;

@Table(name = "post")
@Entity
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    // targetEntity: 관계 맺을 클래스
    // fetch: 읽기 전략, EAGER = 미리, LAZY = 요청하는 순간
    // cascade: 영속성 전이
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
}
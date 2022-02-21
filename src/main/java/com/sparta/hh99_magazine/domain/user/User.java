package com.sparta.hh99_magazine.domain.user;

import com.sparta.hh99_magazine.domain.Timestamped;

import javax.persistence.*;

@Entity
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private String password;
}

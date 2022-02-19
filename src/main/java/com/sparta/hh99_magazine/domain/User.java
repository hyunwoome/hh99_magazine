package com.sparta.hh99_magazine.domain;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String password;
}

package com.sparta.hh99_magazine.domain.user;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;

import javax.persistence.*;

@Entity
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User() {}

    public User(SignupRequestDto signupRequestDto) {
        this.username = signupRequestDto.getUsername();
        this.name = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
    }
}

package com.sparta.hh99_magazine.domain.user;

import com.sparta.hh99_magazine.domain.Timestamped;
import com.sparta.hh99_magazine.web.dto.UserSignupRequestDto;

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

    public User(UserSignupRequestDto userSignupRequestDto) {
        this.username = userSignupRequestDto.getUsername();
        this.name = userSignupRequestDto.getUsername();
        this.password = userSignupRequestDto.getPassword();
    }
}

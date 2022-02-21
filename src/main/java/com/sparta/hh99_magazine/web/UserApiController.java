package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.service.post.UserService;
import com.sparta.hh99_magazine.web.dto.UserSignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/api/signup")
    public Long registerUser(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        return userService.registerUser(userSignupRequestDto);
    }
}

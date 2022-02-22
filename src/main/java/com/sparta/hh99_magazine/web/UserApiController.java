package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.service.user.UserService;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserApiController {
    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    // 로그인


    // 회원 가입
    @PostMapping("/signup")
    public void signupUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.registerUser(signupRequestDto);
    }
}

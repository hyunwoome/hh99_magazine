package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.advice.exception.LoginCheckException;
import com.sparta.hh99_magazine.response.MessageResponse;
import com.sparta.hh99_magazine.service.UserService;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserApiController {
    private final UserService userService;

    // 1. 로그인 후 접근 X
    // 2. 회원가입 후 접근 X

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> signupUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.save(signupRequestDto);
        return new ResponseEntity<>(new MessageResponse("회원가입 성공"), HttpStatus.OK);
    }

    // 로그인 실패
    @GetMapping("/signinError")
    public void signinError() {
        throw new LoginCheckException();
    }
}

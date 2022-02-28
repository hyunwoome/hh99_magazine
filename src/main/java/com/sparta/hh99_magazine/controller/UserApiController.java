package com.sparta.hh99_magazine.controller;

import com.sparta.hh99_magazine.dto.SigninRequestDto;
import com.sparta.hh99_magazine.dto.SigninResponseDto;
import com.sparta.hh99_magazine.dto.SignupRequestDto;
import com.sparta.hh99_magazine.message.SigninMessageResponse;
import com.sparta.hh99_magazine.message.DefaultMessageResponse;
import com.sparta.hh99_magazine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserApiController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<DefaultMessageResponse> createUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.createUser(signupRequestDto);
        return new ResponseEntity<>(new DefaultMessageResponse("회원 가입을 축하합니다."), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/signin")
    public ResponseEntity<SigninMessageResponse> signinUser(@RequestBody SigninRequestDto signinRequestDto) {
        SigninResponseDto userData = userService.signinUser(signinRequestDto);
        return new ResponseEntity<>(new SigninMessageResponse("로그인 되었습니다.", userData), HttpStatus.OK);
    }
}

package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.security.UserDetailsImpl;
import com.sparta.hh99_magazine.service.user.UserService;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserApiController {
    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 (페이지단)
//    @GetMapping("/api/signin")
//    public ResponseEntity signinUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return new ResponseEntity("로그인페이지", HttpStatus.OK);
//    }

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity signupUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.registerUser(signupRequestDto);
        return new ResponseEntity("회원가입 완료", HttpStatus.OK);
    }
}

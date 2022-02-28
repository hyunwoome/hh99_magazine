package com.sparta.hh99_magazine.controller;

import com.sparta.hh99_magazine.dto.SigninRequestDto;
import com.sparta.hh99_magazine.dto.SigninResponseDto;
import com.sparta.hh99_magazine.dto.SignupRequestDto;
import com.sparta.hh99_magazine.message.MessageDataResponse;
import com.sparta.hh99_magazine.message.MessageResponse;
import com.sparta.hh99_magazine.security.JwtTokenProvider;
//import com.sparta.hh99_magazine.security.UserDetailsImpl;
import com.sparta.hh99_magazine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserApiController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> createUser(@RequestBody SignupRequestDto signupRequestDto) {
        userService.createUser(signupRequestDto);
        return new ResponseEntity<>(new MessageResponse("회원 가입을 축하합니다."), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<MessageDataResponse> signinUser(@RequestBody SigninRequestDto signinRequestDto) {
        SigninResponseDto userData = userService.signinUser(signinRequestDto);
        return new ResponseEntity<>(new MessageDataResponse("로그인 되었습니다.", userData), HttpStatus.OK);
    }

    // 로그인
//    @PostMapping("/signin")
//    public ResponseEntity<MessageDataResponse> signinUser(@RequestBody SigninRequestDto signinRequestDto) {
//        SigninResponseDto userData = userService.signinUser(signinRequestDto);
//        return new ResponseEntity<>(new MessageDataResponse("로그인 되었습니다.", userData), HttpStatus.OK);
//    }

    // 로그인 후 로그인 접근 X
//    @GetMapping("/signin")
//    public ResponseEntity<MessageResponse> signinPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails != null) {
//            throw new LoginDuplicateException();
//        }
//        return new ResponseEntity<>(new MessageResponse("로그인 페이지 접근"), HttpStatus.OK);
//    }

//    // 로그인 후 회원가입 접근 X
//    @GetMapping("/signup")
//    public ResponseEntity<MessageResponse> signupPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails != null) {
//            throw new LoginDuplicateException();
//        }
//        return new ResponseEntity<>(new MessageResponse("회원가입 페이지 접근"), HttpStatus.OK);
//    }

    // 회원가입
//    @PostMapping("/signup")
//    public ResponseEntity<MessageResponse> signupUser(@RequestBody SignupRequestDto signupRequestDto) {
//        userService.save(signupRequestDto);
//        return new ResponseEntity<>(new MessageResponse("회원가입 성공"), HttpStatus.OK);
//    }
//
//    // 로그인 실패
//    @GetMapping("/signinError")
//    public void signinError() {
//        throw new LoginCheckException();
//    }
//
//    // 로그아웃 성공
//    @GetMapping("/signoutSuccess")
//    public ResponseEntity<MessageResponse> signOut() {
//        return new ResponseEntity<>(new MessageResponse("로그아웃 성공"), HttpStatus.OK);
//    }
}

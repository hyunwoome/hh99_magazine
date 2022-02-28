package com.sparta.hh99_magazine.advice;

import com.sparta.hh99_magazine.advice.exception.*;
import com.sparta.hh99_magazine.message.DefaultMessageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Getter
@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(PasswordNotSameException.class)
    public ResponseEntity<DefaultMessageResponse> PasswordNotSameException(PasswordNotSameException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("비밀번호가 일치하지 않습니다."), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UsernameNotFoundCustomException.class)
    public ResponseEntity<DefaultMessageResponse> UsernameNotFoundException(UsernameNotFoundCustomException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("아이디가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameValidateException.class)
    public ResponseEntity<DefaultMessageResponse> UsernameValidateException(UsernameValidateException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("아이디는 3글자 이상, 알파벳 대소문자 또는 숫자만 가능합니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordValidateException.class)
    public ResponseEntity<DefaultMessageResponse> PasswordValidateException(PasswordValidateException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("비밀번호는 4글자 이상, 알파벳 대소문자와 숫자만 가능하며, 아이디와 동일할 수 없습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameDuplicateException.class)
    public ResponseEntity<DefaultMessageResponse> UsernameDuplicateException(UsernameDuplicateException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("중복된 아이디가 존재합니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginCheckException.class)
    public ResponseEntity<DefaultMessageResponse> LoginCheckException(LoginCheckException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("아이디와 비밀번호를 확인해주세요."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginDuplicateException.class)
    public ResponseEntity<DefaultMessageResponse> LoginDuplicateException(LoginDuplicateException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("이미 로그인 되어있습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginRequireException.class)
    public ResponseEntity<DefaultMessageResponse> LoginRequireException(LoginRequireException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("로그인을 해야합니다."), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PostIdNotFoundException.class)
    public ResponseEntity<DefaultMessageResponse> PostIdNotFoundException(PostIdNotFoundException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("게시글을 찾을 수 없습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotSameException.class)
    public ResponseEntity<DefaultMessageResponse> UsernameNotSameException(UsernameNotSameException e) {
        return new ResponseEntity<>(new DefaultMessageResponse("게시글 주인만 삭제가 가능합니다."), HttpStatus.UNAUTHORIZED);
    }
}

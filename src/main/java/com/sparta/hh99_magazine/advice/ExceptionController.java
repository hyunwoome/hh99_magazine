package com.sparta.hh99_magazine.advice;

import com.sparta.hh99_magazine.advice.exception.*;
import com.sparta.hh99_magazine.response.MessageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
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

    @ExceptionHandler(UsernameValidateException.class)
    public ResponseEntity<MessageResponse> UsernameValidateException(UsernameValidateException e) {
        return new ResponseEntity<>(new MessageResponse("아이디는 3글자 이상, 알파벳 대소문자 또는 숫자만 가능합니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordValidateException.class)
    public ResponseEntity<MessageResponse> PasswordValidateException(PasswordValidateException e) {
        return new ResponseEntity<>(new MessageResponse("비밀번호는 4글자 이상, 알파벳 대소문자와 숫자만 가능하며, 아이디와 동일할 수 없습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameDuplicateException.class)
    public ResponseEntity<MessageResponse> UsernameDuplicateException(UsernameDuplicateException e) {
        return new ResponseEntity<>(new MessageResponse("중복된 아이디가 존재합니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginCheckException.class)
    public ResponseEntity<MessageResponse> LoginCheckException(LoginCheckException e) {
        return new ResponseEntity<>(new MessageResponse("아이디와 비밀번호를 확인해주세요."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginDuplicateException.class)
    public ResponseEntity<MessageResponse> LoginDuplicateException(LoginDuplicateException e) {
        return new ResponseEntity<>(new MessageResponse("이미 로그인 되어있습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginRequireException.class)
    public ResponseEntity<MessageResponse> LoginRequireException(LoginRequireException e) {
        return new ResponseEntity<>(new MessageResponse("로그인을 해야합니다."), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PostIdNotFoundException.class)
    public ResponseEntity<MessageResponse> PostIdNotFoundException(PostIdNotFoundException e) {
        return new ResponseEntity<>(new MessageResponse("게시글을 찾을 수 없습니다."), HttpStatus.BAD_REQUEST);
    }
}

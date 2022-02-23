package com.sparta.hh99_magazine.advice;

import com.sparta.hh99_magazine.advice.exception.PasswordValidateException;
import com.sparta.hh99_magazine.advice.exception.UsernameValidateException;
import com.sparta.hh99_magazine.response.MessageResponse;
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

    @ExceptionHandler(UsernameValidateException.class)
    public ResponseEntity<MessageResponse> UsernameValidateException(UsernameValidateException e) {
        return new ResponseEntity<>(new MessageResponse("아이디는 3글자 이상, 알파벳 대소문자 또는 숫자만 가능합니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordValidateException.class)
    public ResponseEntity<MessageResponse> PasswordValidateException(PasswordValidateException e) {
        return new ResponseEntity<>(new MessageResponse("비밀번호는 4글자 이상, 알파벳 대소문자와 숫자만 가능하며, 아이디와 동일할 수 없습니다."), HttpStatus.BAD_REQUEST);
    }


}

package com.sparta.hh99_magazine.validator;

import com.sparta.hh99_magazine.advice.exception.PasswordValidateException;
import com.sparta.hh99_magazine.advice.exception.UsernameDuplicateException;
import com.sparta.hh99_magazine.advice.exception.UsernameValidateException;
import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.SignupRequestDto;
import com.sparta.hh99_magazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SignupValidator {
    private final UserRepository userRepository;

    public void validateSignup(SignupRequestDto userRequestDto) {
        Optional<User> user = userRepository.findByUsername(userRequestDto.getUsername());
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        String check_password = userRequestDto.getCheck_password();

        if (user.isPresent()) throw new UsernameDuplicateException();

        if (!(username.length() > 2 && username.matches("^[A-Za-z0-9]*$"))) {
            throw new UsernameValidateException(); }

        if (!(password.length() > 3 && !(password.equals(username)) && password.equals(check_password))) {
            throw new PasswordValidateException(); }
    }
}

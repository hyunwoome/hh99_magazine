package com.sparta.hh99_magazine.validator;

import com.sparta.hh99_magazine.advice.exception.PasswordNotSameException;
import com.sparta.hh99_magazine.advice.exception.UsernameNotFoundCustomException;
import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.SigninRequestDto;
import com.sparta.hh99_magazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SigninValidator {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User validateSignin(SigninRequestDto signinRequestDto) {
        User user = userRepository.findByUsername(signinRequestDto.getUsername())
                .orElseThrow(UsernameNotFoundCustomException::new);
        if (!passwordEncoder.matches(signinRequestDto.getPassword(), user.getPassword())) {
            throw new PasswordNotSameException();
        }
        return user;
    }
}

package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.SigninRequestDto;
import com.sparta.hh99_magazine.dto.SigninResponseDto;
import com.sparta.hh99_magazine.dto.SignupRequestDto;
import com.sparta.hh99_magazine.repository.UserRepository;
import com.sparta.hh99_magazine.security.JwtTokenProvider;
import com.sparta.hh99_magazine.validator.SigninValidator;
import com.sparta.hh99_magazine.validator.SignupValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SignupValidator signupValidator;
    private final SigninValidator signinValidator;

    public void createUser(SignupRequestDto signupRequestDto) {
        signupValidator.validateSignup(signupRequestDto);
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());
        User user = User.builder()
                .username(signupRequestDto.getUsername())
                .name(signupRequestDto.getName())
                .password(encodedPassword)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        userRepository.save(user);
    }

    public SigninResponseDto signinUser(SigninRequestDto signinRequestDto) {
        User user = signinValidator.validateSignin(signinRequestDto);
        String username = user.getUsername();
        List<String> role = user.getRoles();
        return SigninResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .token(jwtTokenProvider.createToken(username, role))
                .build();
    }
}
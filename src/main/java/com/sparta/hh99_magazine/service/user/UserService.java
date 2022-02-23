package com.sparta.hh99_magazine.service.user;

import com.sparta.hh99_magazine.advice.exception.PasswordValidateException;
import com.sparta.hh99_magazine.advice.exception.UsernameValidateException;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.domain.user.UserRepository;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public void registerUser(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String name = signupRequestDto.getName();
        String password = signupRequestDto.getPassword();
        String check_password = signupRequestDto.getCheck_password();
        if (!(isValidateUsername(username))) { throw new UsernameValidateException(); }
        if (!(isValidatePassword(username, password, check_password))) { throw new PasswordValidateException(); }
        User user = new User(username, name, passwordEncoder.encode(password));
        userRepository.save(user);
    }

    private boolean isValidateUsername(String username) {
        return username.length() > 2 && username.matches("^[A-Za-z0-9]*$");
    }

    private boolean isValidatePassword(String username, String password, String check_password) {
        return password.length() > 3 && !(password.equals(username)) && password.equals(check_password);
    }
}
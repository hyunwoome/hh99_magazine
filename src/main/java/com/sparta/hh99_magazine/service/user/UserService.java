package com.sparta.hh99_magazine.service.user;

import com.sparta.hh99_magazine.advice.exception.PasswordValidateException;
import com.sparta.hh99_magazine.advice.exception.UsernameDuplicateException;
import com.sparta.hh99_magazine.advice.exception.UsernameValidateException;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.domain.user.UserRepository;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public void registerUser(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String name = signupRequestDto.getName();
        String password = signupRequestDto.getPassword();
        String check_password = signupRequestDto.getCheck_password();
        // 중복 Username 존재
        if (!(isDuplicateUsername(username))) {throw new UsernameDuplicateException();}
        // 닉네임은 최소 3자 이상, 알파벳 대소문자, 숫자로 구성
        if (!(isValidateUsername(username))) {throw new UsernameValidateException();}
        // 비밀번호는 최소 4자 이상, 닉네임과 같은 값이 포함된 경우 실패, 비밀번호와 확인 비밀번호는 일치
        if (!(isValidatePassword(username, password, check_password))) {throw new PasswordValidateException();}
        User user = new User(username, name, passwordEncoder.encode(password));
        userRepository.save(user);
    }

    private boolean isDuplicateUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return !(user.isPresent());
    }

    private boolean isValidateUsername(String username) {
        return username.length() > 2 && username.matches("^[A-Za-z0-9]*$");
    }

    private boolean isValidatePassword(String username, String password, String check_password) {
        return password.length() > 3 && !(password.equals(username)) && password.equals(check_password);
    }
}
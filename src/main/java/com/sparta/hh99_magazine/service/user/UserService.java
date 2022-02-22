package com.sparta.hh99_magazine.service.user;

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
        // Model에서 구현
        // 1. 닉네임은 최소 3자 이상, 알파벳 대소문자, 숫자로만 구성
        // 2. 비밀번호는 최소 4자 이상, 닉네임과 같을 시 회원가입 실패
        // 3. 비밀번호 확인은 비밀번호와 정확하게 일치
        User user = new User(username, name, passwordEncoder.encode(password));
        userRepository.save(user);
    }
}

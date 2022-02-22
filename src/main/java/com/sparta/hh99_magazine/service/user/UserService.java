package com.sparta.hh99_magazine.service.user;

import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.domain.user.UserRepository;
import com.sparta.hh99_magazine.web.dto.SignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인
//    public void

    // 회원가입
    public void registerUser(SignupRequestDto signupRequestDto) {
        User user = new User(signupRequestDto);
        // Model에서 구현
        // 1. 닉네임은 최소 3자 이상, 알파벳 대소문자, 숫자로만 구성
        // 2. 비밀번호는 최소 4자 이상, 닉네임과 같을 시 회원가입 실패
        // 3. 비밀번호 확인은 비밀번호와 정확하게 일치
        userRepository.save(user);
    }
}

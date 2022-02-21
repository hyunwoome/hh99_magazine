package com.sparta.hh99_magazine.service.post;

import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.domain.user.UserRepository;
import com.sparta.hh99_magazine.web.dto.UserSignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long registerUser(UserSignupRequestDto userSignupRequestDto) {
        User user = new User(userSignupRequestDto);
        userRepository.save(user);
        return user.getId();
    }

}

package com.sparta.hh99_magazine.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // select * from user where username = 1? (첫 번째 파라미터 매핑)
//    public User findByUsername(String username);
}

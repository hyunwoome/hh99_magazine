package com.sparta.hh99_magazine.repository;

import com.sparta.hh99_magazine.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

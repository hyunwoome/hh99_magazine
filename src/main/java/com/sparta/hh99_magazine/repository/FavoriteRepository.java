package com.sparta.hh99_magazine.repository;

import com.sparta.hh99_magazine.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query("select count(f) from Favorite f where f.post.id = :postID")
    int countByPostId(@Param("postID") Long id);

    @Query("select f from Favorite f where f.user.id = :userId and f.post.id = :postId")
    Optional<Favorite> findByUserIdAndPostId(@Param("userId") Long userId, @Param("postId") Long postId);
}

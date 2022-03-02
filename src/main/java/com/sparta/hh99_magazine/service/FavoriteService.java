package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.advice.exception.PostIdNotFoundException;
import com.sparta.hh99_magazine.domain.Favorite;
import com.sparta.hh99_magazine.domain.Post;
import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.PostResponseDto;
import com.sparta.hh99_magazine.repository.FavoriteRepository;
import com.sparta.hh99_magazine.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final PostRepository postRepository;

    public PostResponseDto createFavorite(Long postId, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostIdNotFoundException::new);

        Long currentPostId = post.getId();
        Long currentUserId = user.getId();

        Optional<Favorite> favorite = favoriteRepository
                .findByUserIdAndPostId(currentUserId, currentPostId);

        if (favorite.isPresent()) {
            favoriteRepository.delete(favorite.get());
            return CreateFavoriteResponse(user, post);
        } else {
            Favorite newFavorite = new Favorite(post, user);
            favoriteRepository.save(newFavorite);
            return CreateFavoriteResponse(user, post);
        }
    }

    private PostResponseDto CreateFavoriteResponse(User user, Post post) {
        int countByPostId = favoriteRepository.countByPostId(post.getId());
        Optional<Favorite> favoriteUserId = favoriteRepository.findByUserIdAndPostId(user.getId(), post.getId());
        return PostResponseDto.builder()
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .postId(post.getId())
                .imgUrl(post.getImgUrl())
                .contents(post.getContents())
                .userId(user.getId())
                .likeCnt(countByPostId)
                .isLike(favoriteUserId.isPresent())
                .build();
    }
}

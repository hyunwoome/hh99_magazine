package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.advice.exception.PostIdNotFoundException;
import com.sparta.hh99_magazine.domain.Favorite;
import com.sparta.hh99_magazine.domain.Post;
import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.PostResponseDto;
import com.sparta.hh99_magazine.repository.FavoriteRepository;
import com.sparta.hh99_magazine.repository.PostRepository;
import com.sparta.hh99_magazine.dto.CreatePostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    private final FavoriteRepository favoriteRepository;

    // 전체 (비로그인)
    public List<PostResponseDto> readPosts() {
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<Post> allPosts = postRepository.findAll();
        allPosts.forEach(post -> postResponseDtos.add(createPostResponse(post)));
        return postResponseDtos;
    }

    // 전체 (로그인)
    public List<PostResponseDto> readSigninPosts(User user) {
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        List<Post> allPosts = postRepository.findAll();
        allPosts.forEach(post -> postResponseDtos.add(CreateSigninPostResponse(user, post)));
        return postResponseDtos;
    }

    // 작성
    public PostResponseDto createPost(CreatePostRequestDto createPostRequestDto, User postedUser) {
        Post post = Post.builder()
                .imgUrl(createPostRequestDto.getImgUrl())
                .contents(createPostRequestDto.getContents())
                .user(postedUser)
                .build();
        postRepository.save(post);
        return CreateSigninPostResponse(postedUser, post);
    }

    // 수정
    public PostResponseDto updatePost(Long id, CreatePostRequestDto createPostRequestDto, User user) {
        Post post = postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
        post.update(createPostRequestDto);
        return CreateSigninPostResponse(user, post);
    }

    // 삭제
    public void deletePost(Long postId, Long userId) {
        Optional<Favorite> favorite = favoriteRepository
                .findByUserIdAndPostId(userId, postId);
        favorite.ifPresent(favoriteRepository::delete);
        Post post = postRepository.findById(postId).orElseThrow(PostIdNotFoundException::new);
        postRepository.delete(post);
    }

    // Response (로그인)
    private PostResponseDto CreateSigninPostResponse(User user, Post post) {
        int countByPostId = favoriteRepository.countByPostId(post.getId());
        Optional<Favorite> favoriteUserId = favoriteRepository.findByUserIdAndPostId(user.getId(), post.getId());
        return PostResponseDto.builder()
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .postId(post.getId())
                .imgUrl(post.getImgUrl())
                .contents(post.getContents())
                .userId(post.getUser().getId())
                .likeCnt(countByPostId)
                .isLike(favoriteUserId.isPresent())
                .build();
    }

    // Response (비로그인)
    private PostResponseDto createPostResponse(Post post) {
        int countByPostId = favoriteRepository.countByPostId(post.getId());
        return PostResponseDto.builder()
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .postId(post.getId())
                .imgUrl(post.getImgUrl())
                .contents(post.getContents())
                .userId(post.getUser().getId())
                .likeCnt(countByPostId)
                .isLike(false)
                .build();
    }
}
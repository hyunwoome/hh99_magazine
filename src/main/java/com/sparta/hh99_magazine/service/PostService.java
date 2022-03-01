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
import java.util.Optional;


@RequiredArgsConstructor
@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    private final FavoriteRepository favoriteRepository;

    // 전체 게시글 가져오기

    // 게시글 가져오기

    // 게시글 작성하기
    public PostResponseDto createPost(CreatePostRequestDto createPostRequestDto, User postedUser) {
        Post post = Post.builder()
                .imgUrl(createPostRequestDto.getImgUrl())
                .contents(createPostRequestDto.getContents())
                .user(postedUser)
                .build();
        postRepository.save(post);
        return getCreatePostResponseDto(postedUser, post);
    }

    // 게시글 수정하기
    public PostResponseDto updatePost(Long id, CreatePostRequestDto createPostRequestDto, User user) {
        Post post = postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
        post.update(createPostRequestDto);
        return getCreatePostResponseDto(user, post);
    }

    // 데이터 가공 후 응답
    private PostResponseDto getCreatePostResponseDto(User user, Post post) {
        int countByPostId = favoriteRepository.countByPostId(post.getId());
        Optional<Favorite> favoriteUserId = favoriteRepository.findByUserIdAndPostId(user.getId());

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

    // 게시글 삭제하기
}


//    @Transactional
//    public Post findPost(Long id) {
//        return postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        postRepository.delete(findPost(id));
//    }
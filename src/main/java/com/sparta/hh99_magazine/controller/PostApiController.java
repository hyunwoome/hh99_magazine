package com.sparta.hh99_magazine.controller;

import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.CreatePostRequestDto;
import com.sparta.hh99_magazine.dto.PostResponseDto;
import com.sparta.hh99_magazine.message.PostMessageResponse;
import com.sparta.hh99_magazine.message.DefaultMessageResponse;
import com.sparta.hh99_magazine.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PostApiController {
    private final PostService postService;

    // 전체 (비로그인)
    @GetMapping("/posts")
    public List<PostResponseDto> readPosts() {
        return postService.readPosts();
    }


    // 전체 (로그인)
    @GetMapping("/posts/signed")
    public List<PostResponseDto> readSigninPosts(@AuthenticationPrincipal User user) {
        return postService.readSigninPosts(user);
    }

    // 작성
    @PostMapping("/posts")
    public ResponseEntity<PostMessageResponse> createPost(@RequestBody CreatePostRequestDto createPostRequestDto,
                                                          @AuthenticationPrincipal User user) {
        PostResponseDto postResponse = postService.createPost(createPostRequestDto, user);
        return new ResponseEntity<>(new PostMessageResponse("게시글을 생성했습니다", postResponse), HttpStatus.OK);
    }

    // 수정
    @PatchMapping("/posts/{id}")
    public ResponseEntity<PostMessageResponse> updatePost(@PathVariable Long id,
                                                          @RequestBody CreatePostRequestDto createPostRequestDto,
                                                          @AuthenticationPrincipal User user) {
        PostResponseDto postResponse = postService.updatePost(id, createPostRequestDto, user);
        return new ResponseEntity<>(new PostMessageResponse("게시글이 수정되었습니다", postResponse), HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<DefaultMessageResponse> deletePost(@PathVariable Long id,
                                                             @AuthenticationPrincipal User user) {
        postService.deletePost(id, user.getId());
        return new ResponseEntity<>(new DefaultMessageResponse("게시글이 삭제되었습니다."), HttpStatus.OK);
    }
}

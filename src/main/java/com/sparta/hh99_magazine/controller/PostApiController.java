package com.sparta.hh99_magazine.controller;

import com.sparta.hh99_magazine.domain.Post;
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

    // 전체 게시글 가져오기
    @GetMapping("/posts")
    public List<PostResponseDto> readPosts(@AuthenticationPrincipal User user) {
        return postService.readPosts(user);
    }

    // 게시글 작성하기
    @PostMapping("/posts")
    public ResponseEntity<PostMessageResponse> createPost(@RequestBody CreatePostRequestDto createPostRequestDto,
                                                          @AuthenticationPrincipal User user) {
        PostResponseDto postResponse = postService.createPost(createPostRequestDto, user);
        return new ResponseEntity<>(new PostMessageResponse("게시글을 생성했습니다", postResponse), HttpStatus.OK);
    }

    // 게시글 수정하기
    @PatchMapping("/posts/{id}")
    public ResponseEntity<PostMessageResponse> updatePost(@PathVariable Long id,
                                                          @RequestBody CreatePostRequestDto createPostRequestDto,
                                                          @AuthenticationPrincipal User user) {
        PostResponseDto postResponse = postService.updatePost(id, createPostRequestDto, user);
        return new ResponseEntity<>(new PostMessageResponse("게시글이 수정되었습니다", postResponse), HttpStatus.OK);
    }

    // 게시글 삭제하기
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<DefaultMessageResponse> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(new DefaultMessageResponse("게시글이 삭제되었습니다."), HttpStatus.OK);
    }
}

package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.service.post.PostService;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import com.sparta.hh99_magazine.web.dto.PostResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostApiController {
    private PostService postService;

    public PostApiController() {
    }

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    // 모든 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts().stream().map(PostResponseDto::new).collect(Collectors.toList());
    }

    // 특정 게시물 조회 (디테일)
    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 게시물 작성
    @PostMapping("/api/posts")
    public Long createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }
}

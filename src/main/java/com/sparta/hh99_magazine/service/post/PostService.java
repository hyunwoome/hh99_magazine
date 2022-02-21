package com.sparta.hh99_magazine.service.post;

import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.post.PostRepository;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import com.sparta.hh99_magazine.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 모든 게시물 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 게시물 조회 (디테일)
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 없습니다"));
        return new PostResponseDto(post);
    }

    // 게시물 작성
    @Transactional
    public Long createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return post.getId();
    }
}

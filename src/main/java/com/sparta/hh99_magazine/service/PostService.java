package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.advice.exception.PostIdNotFoundException;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.post.PostRepository;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void save(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
    }

    @Transactional
    public void delete(Long id) {
        postRepository.delete(findPost(id));
    }

    @Transactional
    public void update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
        post.update(postRequestDto);
    }
}

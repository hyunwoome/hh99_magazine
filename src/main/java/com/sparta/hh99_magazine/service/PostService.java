package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.advice.exception.PostIdNotFoundException;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.post.PostRepository;
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
    public void delete(Long id) {
        Post postById = postRepository.findById(id).orElseThrow(PostIdNotFoundException::new);
        postRepository.delete(postById);
    }
}

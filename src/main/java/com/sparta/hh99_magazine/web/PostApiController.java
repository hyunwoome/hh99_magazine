package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.advice.exception.LoginRequireException;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.response.MessageResponse;
import com.sparta.hh99_magazine.security.UserDetailsImpl;
//import com.sparta.hh99_magazine.service.PostService;
import com.sparta.hh99_magazine.service.PostService;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PostApiController {
    private final PostService postService;

    // 전체 게시글 받아오기 (로그인-좋아요 / 비로그인)


    // 게시글 작성 (로그인)
    @PostMapping("/posts")
    public ResponseEntity<MessageResponse> save(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            throw new LoginRequireException();
        }
        String imgUrl = postRequestDto.getImgUrl();
        String contents = postRequestDto.getContents();
        User user = userDetails.getUser();
        Post post = new Post(imgUrl, contents, user);
        postService.save(post);
        return new ResponseEntity<>(new MessageResponse("게시글 등록 완료"), HttpStatus.OK);
    }


    // 게시글 삭제 (로그인)


    // 게시글 수정 (로그인)
}

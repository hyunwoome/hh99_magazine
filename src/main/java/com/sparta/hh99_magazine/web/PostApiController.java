package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.advice.exception.LoginRequireException;
import com.sparta.hh99_magazine.advice.exception.UsernameNotSameException;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.response.MessageResponse;
import com.sparta.hh99_magazine.security.UserDetailsImpl;
import com.sparta.hh99_magazine.service.PostService;
import com.sparta.hh99_magazine.web.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PostApiController {
    private final PostService postService;

    // 전체 게시글 받아오기 (로그인-좋아요 / 비로그인)


    // 게시글 작성 (로그인 필)
    @PostMapping("/posts")
    public ResponseEntity<MessageResponse> createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) { throw new LoginRequireException(); }
        String imgUrl = postRequestDto.getImgUrl();
        String contents = postRequestDto.getContents();
        User user = userDetails.getUser();
        Post post = new Post(imgUrl, contents, user);
        postService.save(post);
        return new ResponseEntity<>(new MessageResponse("게시글 등록 완료"), HttpStatus.OK);
    }

    // 게시글 삭제 (로그인 필)
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<MessageResponse> deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) { throw new LoginRequireException(); }
        if (Objects.equals(userDetails.getUsername(), postService.findPost(id).getUser().getUsername())) { postService.delete(id); }
        else { throw new UsernameNotSameException(); }
        return new ResponseEntity<>(new MessageResponse("게시글이 삭제되었습니다."), HttpStatus.OK);
    }

    // 게시글 수정 (로그인 필)
    @PatchMapping("/posts/{id}")
    public ResponseEntity<MessageResponse> updatePost(@PathVariable Long id,
                                                      @RequestBody PostRequestDto postRequestDto,
                                                      @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) { throw new LoginRequireException(); }
        if (Objects.equals(userDetails.getUsername(), postService.findPost(id).getUser().getUsername())) {
            postService.update(id, postRequestDto);
        }
        else { throw new UsernameNotSameException(); }
        return new ResponseEntity<>(new MessageResponse("게시글이 수정되었습니다."), HttpStatus.OK);
    }
}

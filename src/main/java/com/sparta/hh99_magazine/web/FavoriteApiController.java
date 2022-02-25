package com.sparta.hh99_magazine.web;

import com.sparta.hh99_magazine.advice.exception.LoginRequireException;
import com.sparta.hh99_magazine.domain.favorite.Favorite;
import com.sparta.hh99_magazine.domain.post.Post;
import com.sparta.hh99_magazine.domain.user.User;
import com.sparta.hh99_magazine.response.MessageResponse;
import com.sparta.hh99_magazine.security.UserDetailsImpl;
import com.sparta.hh99_magazine.service.FavoriteService;
import com.sparta.hh99_magazine.service.PostService;
import com.sparta.hh99_magazine.web.dto.FavoriteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class FavoriteApiController {

    private final FavoriteService favoriteService;
    private final PostService postService;

    @PostMapping("/favorite/{postId}")
    public FavoriteResponseDto createFavorite(@PathVariable Long postId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            throw new LoginRequireException();
        }
        // user = 현재 로그인된 사용자
        User user = userDetails.getUser();

        // post = 현재 포스트
        Post post = postService.findPost(postId);

        // postUser = 포스트를 작성한 사용자
        User postUser = post.getUser();

        boolean isLike = false;
        int cntLike = favoriteService.countByPostId(postId);
        Optional<Favorite> byUserIdAndPostId = favoriteService.findByUserIdAndPostId(user.getId(), postId);

        if (byUserIdAndPostId.isPresent()) {
            favoriteService.delete(byUserIdAndPostId.get());
            cntLike -= 1;
        } else {
            Favorite newFavorite = new Favorite(post, user);
            favoriteService.save(newFavorite);
            isLike = true;
            cntLike += 1;
        }
        return new FavoriteResponseDto(user.getId(), postId, post.getImgUrl(), post.getContents(), post.getCreatedAt().toString(), post.getModifiedAt().toString(),
                postUser.getUsername(), postUser.getName(), cntLike, isLike);
    }
}

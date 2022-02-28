package com.sparta.hh99_magazine.controller;

//import com.sparta.hh99_magazine.security.UserDetailsImpl;
import com.sparta.hh99_magazine.service.FavoriteService;
import com.sparta.hh99_magazine.service.PostService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class FavoriteApiController {

    private final FavoriteService favoriteService;
    private final PostService postService;

//    @PostMapping("/favorite/{postId}")
//    public FavoriteResponseDto createFavorite(@PathVariable Long postId,
//                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails == null) {
//            throw new LoginRequireException();
//        }
//        // user = 현재 로그인된 사용자
//        User user = userDetails.getUser();
//
//        // post = 현재 포스트
//        Post post = postService.findPost(postId);
//
//        // postUser = 포스트를 작성한 사용자
//        User postUser = post.getUser();
//
//        boolean isLike = false;
//        int cntLike = favoriteService.countByPostId(postId);
//        Optional<Favorite> byUserIdAndPostId = favoriteService.findByUserIdAndPostId(user.getId(), postId);
//
//        if (byUserIdAndPostId.isPresent()) {
//            favoriteService.delete(byUserIdAndPostId.get());
//            cntLike -= 1;
//        } else {
//            Favorite newFavorite = new Favorite(post, user);
//            favoriteService.save(newFavorite);
//            isLike = true;
//            cntLike += 1;
//        }
//        return new FavoriteResponseDto(user.getId(), postId, post.getImgUrl(), post.getContents(), post.getCreatedAt().toString(), post.getModifiedAt().toString(),
//                postUser.getUsername(), postUser.getName(), cntLike, isLike);
//    }
}

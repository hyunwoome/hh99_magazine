package com.sparta.hh99_magazine.controller;

import com.sparta.hh99_magazine.domain.User;
import com.sparta.hh99_magazine.dto.PostResponseDto;
import com.sparta.hh99_magazine.message.PostMessageResponse;
import com.sparta.hh99_magazine.service.FavoriteService;
import com.sparta.hh99_magazine.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class FavoriteApiController {

    private final FavoriteService favoriteService;

    // 좋아요
    @PostMapping("/favorite/{id}")
    public ResponseEntity<PostMessageResponse> createFavorite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        PostResponseDto favoriteResponse = favoriteService.createFavorite(id, user);
        return new ResponseEntity<>(new PostMessageResponse("좋아요 성공", favoriteResponse), HttpStatus.OK);
    }
}
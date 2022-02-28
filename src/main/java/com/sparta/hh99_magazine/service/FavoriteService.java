package com.sparta.hh99_magazine.service;

import com.sparta.hh99_magazine.domain.Favorite;
import com.sparta.hh99_magazine.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public int countByPostId(Long id) {
        return favoriteRepository.countByPostId(id);
    }

    public Optional<Favorite> findByUserIdAndPostId(Long userId) {
        return favoriteRepository.findByUserIdAndPostId(userId);
    }

    public void save(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    public void delete(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }
}

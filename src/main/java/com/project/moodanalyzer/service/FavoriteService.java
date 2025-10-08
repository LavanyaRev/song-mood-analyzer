package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.Favorite;
import com.project.moodanalyzer.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    // Add a favorite
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    // Get all favorites for a user
    public List<Favorite> getFavoritesByUser(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    // Remove favorite by ID
    public void removeFavorite(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }

    // Optional: remove by user + song
    public void removeFavorite(Long userId, Long songId) {
        favoriteRepository.deleteByUserIdAndSongId(userId, songId);
    }
}

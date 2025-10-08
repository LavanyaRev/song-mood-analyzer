package com.project.moodanalyzer.controller;
//FavoriteController.java
import com.project.moodanalyzer.entity.Favorite;
import com.project.moodanalyzer.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    // Add a favorite
    @PostMapping("/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        Favorite saved = favoriteService.addFavorite(favorite);
        return ResponseEntity.ok(saved);
    }

    // Get favorites by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long userId) {
        List<Favorite> favorites = favoriteService.getFavoritesByUser(userId);
        return ResponseEntity.ok(favorites);
    }

    // Remove favorite by favorite ID
    @DeleteMapping("/remove/{favoriteId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long favoriteId) {
        favoriteService.removeFavorite(favoriteId);
        return ResponseEntity.ok().build();
    }

    // Optional: remove by user + song
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFavoriteByUserSong(@RequestParam Long userId, @RequestParam Long songId) {
        favoriteService.removeFavorite(userId, songId);
        return ResponseEntity.ok().build();
    }
}

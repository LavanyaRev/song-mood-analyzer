package com.project.moodanalyzer.repository;

import com.project.moodanalyzer.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUserId(Long userId);

    // Optional: if you ever want to remove by user + song
    void deleteByUserIdAndSongId(Long userId, Long songId);
}
